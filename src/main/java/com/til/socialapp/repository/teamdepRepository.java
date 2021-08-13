package com.til.socialapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.til.socialapp.mongodbdata.*;

public interface teamdepRepository extends MongoRepository<teamdep, Integer> {
	

}
