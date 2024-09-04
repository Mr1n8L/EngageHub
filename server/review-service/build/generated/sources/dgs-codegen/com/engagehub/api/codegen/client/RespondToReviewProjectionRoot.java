package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class RespondToReviewProjectionRoot<PARENT extends BaseSubProjectionNode<?, ?>, ROOT extends BaseSubProjectionNode<?, ?>> extends BaseSubProjectionNode<PARENT, ROOT> {
  public RespondToReviewProjectionRoot() {
    super(null, null, java.util.Optional.of("Review"));
  }

  public RespondToReviewProjectionRoot<PARENT, ROOT> __typename() {
    getFields().put("__typename", null);
    return this;
  }

  public RespondToReviewProjectionRoot<PARENT, ROOT> id() {
    getFields().put("id", null);
    return this;
  }

  public RespondToReviewProjectionRoot<PARENT, ROOT> customerId() {
    getFields().put("customerId", null);
    return this;
  }

  public RespondToReviewProjectionRoot<PARENT, ROOT> businessId() {
    getFields().put("businessId", null);
    return this;
  }

  public RespondToReviewProjectionRoot<PARENT, ROOT> rating() {
    getFields().put("rating", null);
    return this;
  }

  public RespondToReviewProjectionRoot<PARENT, ROOT> comment() {
    getFields().put("comment", null);
    return this;
  }

  public RespondToReviewProjectionRoot<PARENT, ROOT> response() {
    getFields().put("response", null);
    return this;
  }
}
