package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class BusinessesProjectionRoot<PARENT extends BaseSubProjectionNode<?, ?>, ROOT extends BaseSubProjectionNode<?, ?>> extends BaseSubProjectionNode<PARENT, ROOT> {
  public BusinessesProjectionRoot() {
    super(null, null, java.util.Optional.of("Business"));
  }

  public BusinessesProjectionRoot<PARENT, ROOT> __typename() {
    getFields().put("__typename", null);
    return this;
  }

  public BusinessesProjectionRoot<PARENT, ROOT> id() {
    getFields().put("id", null);
    return this;
  }

  public BusinessesProjectionRoot<PARENT, ROOT> name() {
    getFields().put("name", null);
    return this;
  }

  public BusinessesProjectionRoot<PARENT, ROOT> address() {
    getFields().put("address", null);
    return this;
  }

  public BusinessesProjectionRoot<PARENT, ROOT> type() {
    getFields().put("type", null);
    return this;
  }

  public BusinessesProjectionRoot<PARENT, ROOT> contactInformation() {
    getFields().put("contactInformation", null);
    return this;
  }
}
