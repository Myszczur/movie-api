package pl.urbanik.backendmovieapi.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.urbanik.backendmovieapi.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}