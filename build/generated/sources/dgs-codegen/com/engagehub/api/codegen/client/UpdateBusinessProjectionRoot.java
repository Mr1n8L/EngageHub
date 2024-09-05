package com.engagehub.api.codegen.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class UpdateBusinessProjectionRoot<PARENT extends BaseSubProjectionNode<?, ?>, ROOT extends BaseSubProjectionNode<?, ?>> extends BaseSubProjectionNode<PARENT, ROOT> {
  public UpdateBusinessProjectionRoot() {
    super(null, null, java.util.Optional.of("Business"));
  }

  public UpdateBusinessProjectionRoot<PARENT, ROOT> __typename() {
    getFields().put("__typename", null);
    return this;
  }

  public UpdateBusinessProjectionRoot<PARENT, ROOT> id() {
    getFields().put("id", null);
    return this;
  }

  public UpdateBusinessProjectionRoot<PARENT, ROOT> name() {
    getFields().put("name", null);
    return this;
  }

  public UpdateBusinessProjectionRoot<PARENT, ROOT> address() {
    getFields().put("address", null);
    return this;
  }

  public UpdateBusinessProjectionRoot<PARENT, ROOT> type() {
    getFields().put("type", null);
    return this;
  }

  public UpdateBusinessProjectionRoot<PARENT, ROOT> contactInformation() {
    getFields().put("contactInformation", null);
    return this;
  }
}
