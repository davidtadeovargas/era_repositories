package com.era.repositories;

import java.util.List;
import java.util.ArrayList;
import com.era.models.Moninven;

public class MoninvensRepository extends Repository {

    public MoninvensRepository() {
        super(Moninven.class);
    }

    @Override
    final public List<Moninven> getByLikeEncabezados(final String search) throws Exception{

        final List<String> likes = new ArrayList<>();
        likes.add("falt");
        likes.add("fmod");

        final List<Moninven> records = (List<Moninven>) this.getAllLike(likes, search);

        return records;
    }
}