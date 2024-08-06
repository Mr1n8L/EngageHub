package com.engagehub.api.dgs;

import com.engagehub.api.model.Review;
import com.engagehub.api.repository.ReviewRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;

@DgsComponent
public class ReviewDataFetcher {

    private final ReviewRepository reviewRepository;

    public ReviewDataFetcher(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @DgsQuery
    public List<Review> reviews() {
        return reviewRepository.findAll();
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
}
