package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.model.Shoe;
import com.dnstth.bdcg.model.Suit;
import com.dnstth.bdcg.repository.ShoeRepository;
import com.dnstth.bdcg.service.DeckService;
import com.dnstth.bdcg.service.GameService;
import com.dnstth.bdcg.service.ShoeService;
import com.dnstth.bdcg.service.transformer.ShoeTransformer;
import com.dnstth.bdcg.view.CardView;
import com.dnstth.bdcg.view.DeckView;
import com.dnstth.bdcg.view.GameView;
import com.dnstth.bdcg.view.ShoeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

    @Autowired
    private DeckService deckService;

    @Autowired
    private GameService gameService;

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
        if (!optionalShoe.isPresent()) {
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
        if (!optionalShoe.isPresent()) {
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

    @Override
    public void addDeckToShoeById(final String gameId, final String deckId) {
        DeckView deckView = deckService.getDeckById(deckId);
        GameView gameView = gameService.getGameById(gameId);
        gameView.addDeckToShoe(deckView);
        gameService.updateGame(gameView);
    }

    @Override
    public ShoeView shuffle(final String gameId) {
        GameView gameView = gameService.getGameById(gameId);
        Collections.shuffle(gameView.getShoe().getCards());
        gameService.updateGame(gameView);
        return gameView.getShoe();
    }

    @Override
    public String getUndealtCards(final String gameId) {
        List<CardView> cards = gameService.getGameById(gameId).getShoe().getCards();

        Map<Suit, Integer> counters = new HashMap<>();
        Arrays.stream(Suit.values()).forEach(suit -> counters.put(suit, 0));

        cards.forEach(card -> {
            counters.put(card.getSuit(), counters.get(card.getSuit()) + 1);
        });

        return counters.toString();
    }


}
