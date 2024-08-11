package com.engagehub.api.resolver;

import com.engagehub.api.model.Review;
import com.engagehub.api.repository.ReviewRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class ReviewResolver {

    private final ReviewRepository reviewRepository;

    public ReviewResolver(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @DgsQuery
    public List<Review> reviews() {
        return reviewRepository.findAll();
    }

    @DgsQuery
    public Optional<Review> review(@InputArgument Long id) {
        return reviewRepository.findById(id);
    }

    @DgsMutation
    public Review submitReview(@InputArgument Long customerId, @InputArgument Long businessId, @InputArgument int rating, @InputArgument String comment) {
        Review review = new Review();
        review.setCustomerId(customerId);
        review.setBusinessId(businessId);
        review.setRating(rating);
        review.setComment(comment);
        return reviewRepository.save(review);
    }

    @DgsMutation
    public Review respondToReview(@InputArgument Long id, @InputArgument String response) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            review.setResponse(response);  // Assuming you've added a `response` field in the `Review` entity
            return reviewRepository.save(review);
        }
        throw new RuntimeException("Review not found");
    }
}
