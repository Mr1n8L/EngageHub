package com.engagehub.api.dgs;

import com.engagehub.api.model.Review;
import com.engagehub.api.service.ReviewService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class ReviewDataFetcher {

    private final ReviewService reviewService;

    public ReviewDataFetcher(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @DgsQuery
    public List<Review> reviews() {
        return reviewService.getAllReviews();
    }

    @DgsQuery
    public Optional<Review> reviewById(@InputArgument Long id) {
        return reviewService.getReviewById(id);
    }

    @DgsMutation
    public Review submitReview(@InputArgument Long customerId,
                               @InputArgument Long businessId,
                               @InputArgument int rating,
                               @InputArgument String comment) {
        Review review = new Review(customerId, businessId, rating, comment);
        return reviewService.submitReview(review);
    }

    @DgsMutation
    public Review respondToReview(@InputArgument Long reviewId,
                                  @InputArgument String response) {
        return reviewService.respondToReview(reviewId, response);
    }
}
