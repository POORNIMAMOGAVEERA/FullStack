// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schema.proto

package learn.proto.fullstack;

/**
 * Protobuf type {@code learn.proto.fullstack.UpdateEmployeeResponse}
 */
public  final class UpdateEmployeeResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:learn.proto.fullstack.UpdateEmployeeResponse)
    UpdateEmployeeResponseOrBuilder {
  // Use UpdateEmployeeResponse.newBuilder() to construct.
  private UpdateEmployeeResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateEmployeeResponse() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private UpdateEmployeeResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            learn.proto.fullstack.Employee.Builder subBuilder = null;
            if (employee_ != null) {
              subBuilder = employee_.toBuilder();
            }
            employee_ = input.readMessage(learn.proto.fullstack.Employee.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(employee_);
              employee_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return learn.proto.fullstack.Schema.internal_static_learn_proto_fullstack_UpdateEmployeeResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return learn.proto.fullstack.Schema.internal_static_learn_proto_fullstack_UpdateEmployeeResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            learn.proto.fullstack.UpdateEmployeeResponse.class, learn.proto.fullstack.UpdateEmployeeResponse.Builder.class);
  }

  public static final int EMPLOYEE_FIELD_NUMBER = 1;
  private learn.proto.fullstack.Employee employee_;
  /**
   * <code>.learn.proto.fullstack.Employee employee = 1;</code>
   */
  public boolean hasEmployee() {
    return employee_ != null;
  }
  /**
   * <code>.learn.proto.fullstack.Employee employee = 1;</code>
   */
  public learn.proto.fullstack.Employee getEmployee() {
    return employee_ == null ? learn.proto.fullstack.Employee.getDefaultInstance() : employee_;
  }
  /**
   * <code>.learn.proto.fullstack.Employee employee = 1;</code>
   */
  public learn.proto.fullstack.EmployeeOrBuilder getEmployeeOrBuilder() {
    return getEmployee();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (employee_ != null) {
      output.writeMessage(1, getEmployee());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (employee_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getEmployee());
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof learn.proto.fullstack.UpdateEmployeeResponse)) {
      return super.equals(obj);
    }
    learn.proto.fullstack.UpdateEmployeeResponse other = (learn.proto.fullstack.UpdateEmployeeResponse) obj;

    boolean result = true;
    result = result && (hasEmployee() == other.hasEmployee());
    if (hasEmployee()) {
      result = result && getEmployee()
          .equals(other.getEmployee());
    }
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasEmployee()) {
      hash = (37 * hash) + EMPLOYEE_FIELD_NUMBER;
      hash = (53 * hash) + getEmployee().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static learn.proto.fullstack.UpdateEmployeeResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static learn.proto.fullstack.UpdateEmployeeResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(learn.proto.fullstack.UpdateEmployeeResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code learn.proto.fullstack.UpdateEmployeeResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:learn.proto.fullstack.UpdateEmployeeResponse)
      learn.proto.fullstack.UpdateEmployeeResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return learn.proto.fullstack.Schema.internal_static_learn_proto_fullstack_UpdateEmployeeResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return learn.proto.fullstack.Schema.internal_static_learn_proto_fullstack_UpdateEmployeeResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              learn.proto.fullstack.UpdateEmployeeResponse.class, learn.proto.fullstack.UpdateEmployeeResponse.Builder.class);
    }

    // Construct using learn.proto.fullstack.UpdateEmployeeResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (employeeBuilder_ == null) {
        employee_ = null;
      } else {
        employee_ = null;
        employeeBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return learn.proto.fullstack.Schema.internal_static_learn_proto_fullstack_UpdateEmployeeResponse_descriptor;
    }

    public learn.proto.fullstack.UpdateEmployeeResponse getDefaultInstanceForType() {
      return learn.proto.fullstack.UpdateEmployeeResponse.getDefaultInstance();
    }

    public learn.proto.fullstack.UpdateEmployeeResponse build() {
      learn.proto.fullstack.UpdateEmployeeResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public learn.proto.fullstack.UpdateEmployeeResponse buildPartial() {
      learn.proto.fullstack.UpdateEmployeeResponse result = new learn.proto.fullstack.UpdateEmployeeResponse(this);
      if (employeeBuilder_ == null) {
        result.employee_ = employee_;
      } else {
        result.employee_ = employeeBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof learn.proto.fullstack.UpdateEmployeeResponse) {
        return mergeFrom((learn.proto.fullstack.UpdateEmployeeResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(learn.proto.fullstack.UpdateEmployeeResponse other) {
      if (other == learn.proto.fullstack.UpdateEmployeeResponse.getDefaultInstance()) return this;
      if (other.hasEmployee()) {
        mergeEmployee(other.getEmployee());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      learn.proto.fullstack.UpdateEmployeeResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (learn.proto.fullstack.UpdateEmployeeResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private learn.proto.fullstack.Employee employee_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        learn.proto.fullstack.Employee, learn.proto.fullstack.Employee.Builder, learn.proto.fullstack.EmployeeOrBuilder> employeeBuilder_;
    /**
     * <code>.learn.proto.fullstack.Employee employee = 1;</code>
     */
    public boolean hasEmployee() {
      return employeeBuilder_ != null || employee_ != null;
    }
    /**
     * <code>.learn.proto.fullstack.Employee employee = 1;</code>
     */
    public learn.proto.fullstack.Employee getEmployee() {
      if (employeeBuilder_ == null) {
        return employee_ == null ? learn.proto.fullstack.Employee.getDefaultInstance() : employee_;
      } else {
        return employeeBuilder_.getMessage();
      }
    }
    /**
     * <code>.learn.proto.fullstack.Employee employee = 1;</code>
     */
    public Builder setEmployee(learn.proto.fullstack.Employee value) {
      if (employeeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        employee_ = value;
        onChanged();
      } else {
        employeeBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.learn.proto.fullstack.Employee employee = 1;</code>
     */
    public Builder setEmployee(
        learn.proto.fullstack.Employee.Builder builderForValue) {
      if (employeeBuilder_ == null) {
        employee_ = builderForValue.build();
        onChanged();
      } else {
        employeeBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.learn.proto.fullstack.Employee employee = 1;</code>
     */
    public Builder mergeEmployee(learn.proto.fullstack.Employee value) {
      if (employeeBuilder_ == null) {
        if (employee_ != null) {
          employee_ =
            learn.proto.fullstack.Employee.newBuilder(employee_).mergeFrom(value).buildPartial();
        } else {
          employee_ = value;
        }
        onChanged();
      } else {
        employeeBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.learn.proto.fullstack.Employee employee = 1;</code>
     */
    public Builder clearEmployee() {
      if (employeeBuilder_ == null) {
        employee_ = null;
        onChanged();
      } else {
        employee_ = null;
        employeeBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.learn.proto.fullstack.Employee employee = 1;</code>
     */
    public learn.proto.fullstack.Employee.Builder getEmployeeBuilder() {
      
      onChanged();
      return getEmployeeFieldBuilder().getBuilder();
    }
    /**
     * <code>.learn.proto.fullstack.Employee employee = 1;</code>
     */
    public learn.proto.fullstack.EmployeeOrBuilder getEmployeeOrBuilder() {
      if (employeeBuilder_ != null) {
        return employeeBuilder_.getMessageOrBuilder();
      } else {
        return employee_ == null ?
            learn.proto.fullstack.Employee.getDefaultInstance() : employee_;
      }
    }
    /**
     * <code>.learn.proto.fullstack.Employee employee = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        learn.proto.fullstack.Employee, learn.proto.fullstack.Employee.Builder, learn.proto.fullstack.EmployeeOrBuilder> 
        getEmployeeFieldBuilder() {
      if (employeeBuilder_ == null) {
        employeeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            learn.proto.fullstack.Employee, learn.proto.fullstack.Employee.Builder, learn.proto.fullstack.EmployeeOrBuilder>(
                getEmployee(),
                getParentForChildren(),
                isClean());
        employee_ = null;
      }
      return employeeBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:learn.proto.fullstack.UpdateEmployeeResponse)
  }

  // @@protoc_insertion_point(class_scope:learn.proto.fullstack.UpdateEmployeeResponse)
  private static final learn.proto.fullstack.UpdateEmployeeResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new learn.proto.fullstack.UpdateEmployeeResponse();
  }

  public static learn.proto.fullstack.UpdateEmployeeResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateEmployeeResponse>
      PARSER = new com.google.protobuf.AbstractParser<UpdateEmployeeResponse>() {
    public UpdateEmployeeResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new UpdateEmployeeResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateEmployeeResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateEmployeeResponse> getParserForType() {
    return PARSER;
  }

  public learn.proto.fullstack.UpdateEmployeeResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

