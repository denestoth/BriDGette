package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.model.Shoe;
import com.dnstth.bdcg.repository.ShoeRepository;
import com.dnstth.bdcg.service.ShoeService;
import com.dnstth.bdcg.service.transformer.ShoeTransformer;
import com.dnstth.bdcg.view.ShoeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of {@link ShoeService}.
 *
 * @author Denes Toth
 */
@Service
public class MongoShoeService implements ShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    @Autowired
    private ShoeTransformer shoeTransformer;

    @Override
    public List<ShoeView> getShoes() {
        return shoeRepository
                .findAll()
                .stream()
                .map(shoe -> shoeTransformer.transform(shoe))
                .collect(Collectors.toList());
    }

    @Override
    public ShoeView getShoeById(final String id) {
        Optional<Shoe> optionalShoe = shoeRepository.findById(id);
        if (optionalShoe.isEmpty()) {
            //throw new EntityNotFoundException(Shoe.class, id);
        }
        return shoeTransformer.transform(optionalShoe.get());
    }

    @Override
    public ShoeView addShoe(final ShoeView shoeView) {
        Shoe shoe = shoeTransformer.transform(shoeView);
        shoeRepository.save(shoe);
        shoeView.setId(shoe.getId());
        return shoeView;
    }

    @Override
    public ShoeView updateShoe(final ShoeView shoeView) {
        Optional<Shoe> optionalShoe = shoeRepository.findById(shoeView.getId());
        if (optionalShoe.isEmpty()) {
            //throw new EntityNotFoundException(Shoe.class, id);
        }
        Shoe shoe = optionalShoe.get();
        shoe.setCards(shoeTransformer.transform(shoeView).getCards());
        shoeRepository.save(shoe);
        return shoeView;
    }

    @Override
    public void deleteShoe(final String id) {
        shoeRepository.deleteById(id);
    }
}
