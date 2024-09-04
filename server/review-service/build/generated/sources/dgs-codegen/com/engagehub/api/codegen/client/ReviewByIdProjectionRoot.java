package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class ReviewByIdProjectionRoot<PARENT extends BaseSubProjectionNode<?, ?>, ROOT extends BaseSubProjectionNode<?, ?>> extends BaseSubProjectionNode<PARENT, ROOT> {
  public ReviewByIdProjectionRoot() {
    super(null, null, java.util.Optional.of("Review"));
  }

  public ReviewByIdProjectionRoot<PARENT, ROOT> __typename() {
    getFields().put("__typename", null);
    return this;
  }

  public ReviewByIdProjectionRoot<PARENT, ROOT> id() {
    getFields().put("id", null);
    return this;
  }

  public ReviewByIdProjectionRoot<PARENT, ROOT> customerId() {
    getFields().put("customerId", null);
    return this;
  }

  public ReviewByIdProjectionRoot<PARENT, ROOT> businessId() {
    getFields().put("businessId", null);
    return this;
  }

  public ReviewByIdProjectionRoot<PARENT, ROOT> rating() {
    getFields().put("rating", null);
    return this;
  }

  public ReviewByIdProjectionRoot<PARENT, ROOT> comment() {
    getFields().put("comment", null);
    return this;
  }

  public ReviewByIdProjectionRoot<PARENT, ROOT> response() {
    getFields().put("response", null);
    return this;
  }
}
