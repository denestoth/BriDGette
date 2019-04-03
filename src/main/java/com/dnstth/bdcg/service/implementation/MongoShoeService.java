package com.dnstth.bdcg.service.implementation;

import com.dnstth.bdcg.service.ShoeService;
import com.dnstth.bdcg.view.ShoeView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link ShoeService}.
 *
 * @author Denes Toth
 */
@Service
public class MongoShoeService implements ShoeService {
    @Override
    public List<ShoeView> getShoes() {
        return null;
    }

    @Override
    public ShoeView getShoeById(ShoeView shoeView) {
        return null;
    }

    @Override
    public ShoeView addShoe(ShoeView shoeView) {
        return null;
    }

    @Override
    public ShoeView updateShoe(ShoeView shoeView) {
        return null;
    }

    @Override
    public void deleteShoe(String id) {

    }
}
