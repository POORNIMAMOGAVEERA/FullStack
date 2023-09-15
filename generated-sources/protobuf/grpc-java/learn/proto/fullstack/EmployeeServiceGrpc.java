package learn.proto.fullstack;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: schema.proto")
public final class EmployeeServiceGrpc {

  private EmployeeServiceGrpc() {}

  public static final String SERVICE_NAME = "learn.proto.fullstack.EmployeeService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<learn.proto.fullstack.Empty,
      learn.proto.fullstack.GetAllEmpRes> METHOD_GET_ALL_EMPLOYEES =
      io.grpc.MethodDescriptor.<learn.proto.fullstack.Empty, learn.proto.fullstack.GetAllEmpRes>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "learn.proto.fullstack.EmployeeService", "GetAllEmployees"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              learn.proto.fullstack.Empty.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              learn.proto.fullstack.GetAllEmpRes.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<learn.proto.fullstack.CreateEmployeeRequest,
      learn.proto.fullstack.EmployeeResponse> METHOD_CREATE_EMPLOYEE =
      io.grpc.MethodDescriptor.<learn.proto.fullstack.CreateEmployeeRequest, learn.proto.fullstack.EmployeeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "learn.proto.fullstack.EmployeeService", "CreateEmployee"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              learn.proto.fullstack.CreateEmployeeRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              learn.proto.fullstack.EmployeeResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<learn.proto.fullstack.UpdateEmployeeRequest,
      learn.proto.fullstack.UpdateEmployeeResponse> METHOD_UPDATE_EMPLOYEE =
      io.grpc.MethodDescriptor.<learn.proto.fullstack.UpdateEmployeeRequest, learn.proto.fullstack.UpdateEmployeeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "learn.proto.fullstack.EmployeeService", "UpdateEmployee"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              learn.proto.fullstack.UpdateEmployeeRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              learn.proto.fullstack.UpdateEmployeeResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<learn.proto.fullstack.EmployeeRequest,
      learn.proto.fullstack.EmployeeResponse> METHOD_DELETE_EMPLOYEE =
      io.grpc.MethodDescriptor.<learn.proto.fullstack.EmployeeRequest, learn.proto.fullstack.EmployeeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "learn.proto.fullstack.EmployeeService", "DeleteEmployee"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              learn.proto.fullstack.EmployeeRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              learn.proto.fullstack.EmployeeResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<learn.proto.fullstack.EmployeeRequest,
      learn.proto.fullstack.Employee> METHOD_GET_EMPLOYEE =
      io.grpc.MethodDescriptor.<learn.proto.fullstack.EmployeeRequest, learn.proto.fullstack.Employee>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "learn.proto.fullstack.EmployeeService", "getEmployee"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              learn.proto.fullstack.EmployeeRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              learn.proto.fullstack.Employee.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmployeeServiceStub newStub(io.grpc.Channel channel) {
    return new EmployeeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmployeeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EmployeeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmployeeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EmployeeServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EmployeeServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     ** client will send one request and
     *The server processes the request, fetches all employees, and sends single single
     *GetAllEmpRes *
     * </pre>
     */
    public void getAllEmployees(learn.proto.fullstack.Empty request,
        io.grpc.stub.StreamObserver<learn.proto.fullstack.GetAllEmpRes> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ALL_EMPLOYEES, responseObserver);
    }

    /**
     * <pre>
     ** client will send one request and
     *The server processes the request, and sends single single
     *Response *
     * </pre>
     */
    public void createEmployee(learn.proto.fullstack.CreateEmployeeRequest request,
        io.grpc.stub.StreamObserver<learn.proto.fullstack.EmployeeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_EMPLOYEE, responseObserver);
    }

    /**
     */
    public void updateEmployee(learn.proto.fullstack.UpdateEmployeeRequest request,
        io.grpc.stub.StreamObserver<learn.proto.fullstack.UpdateEmployeeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE_EMPLOYEE, responseObserver);
    }

    /**
     */
    public void deleteEmployee(learn.proto.fullstack.EmployeeRequest request,
        io.grpc.stub.StreamObserver<learn.proto.fullstack.EmployeeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_EMPLOYEE, responseObserver);
    }

    /**
     */
    public void getEmployee(learn.proto.fullstack.EmployeeRequest request,
        io.grpc.stub.StreamObserver<learn.proto.fullstack.Employee> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_EMPLOYEE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_ALL_EMPLOYEES,
            asyncUnaryCall(
              new MethodHandlers<
                learn.proto.fullstack.Empty,
                learn.proto.fullstack.GetAllEmpRes>(
                  this, METHODID_GET_ALL_EMPLOYEES)))
          .addMethod(
            METHOD_CREATE_EMPLOYEE,
            asyncUnaryCall(
              new MethodHandlers<
                learn.proto.fullstack.CreateEmployeeRequest,
                learn.proto.fullstack.EmployeeResponse>(
                  this, METHODID_CREATE_EMPLOYEE)))
          .addMethod(
            METHOD_UPDATE_EMPLOYEE,
            asyncUnaryCall(
              new MethodHandlers<
                learn.proto.fullstack.UpdateEmployeeRequest,
                learn.proto.fullstack.UpdateEmployeeResponse>(
                  this, METHODID_UPDATE_EMPLOYEE)))
          .addMethod(
            METHOD_DELETE_EMPLOYEE,
            asyncUnaryCall(
              new MethodHandlers<
                learn.proto.fullstack.EmployeeRequest,
                learn.proto.fullstack.EmployeeResponse>(
                  this, METHODID_DELETE_EMPLOYEE)))
          .addMethod(
            METHOD_GET_EMPLOYEE,
            asyncUnaryCall(
              new MethodHandlers<
                learn.proto.fullstack.EmployeeRequest,
                learn.proto.fullstack.Employee>(
                  this, METHODID_GET_EMPLOYEE)))
          .build();
    }
  }

  /**
   */
  public static final class EmployeeServiceStub extends io.grpc.stub.AbstractStub<EmployeeServiceStub> {
    private EmployeeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     ** client will send one request and
     *The server processes the request, fetches all employees, and sends single single
     *GetAllEmpRes *
     * </pre>
     */
    public void getAllEmployees(learn.proto.fullstack.Empty request,
        io.grpc.stub.StreamObserver<learn.proto.fullstack.GetAllEmpRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_EMPLOYEES, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     ** client will send one request and
     *The server processes the request, and sends single single
     *Response *
     * </pre>
     */
    public void createEmployee(learn.proto.fullstack.CreateEmployeeRequest request,
        io.grpc.stub.StreamObserver<learn.proto.fullstack.EmployeeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_EMPLOYEE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateEmployee(learn.proto.fullstack.UpdateEmployeeRequest request,
        io.grpc.stub.StreamObserver<learn.proto.fullstack.UpdateEmployeeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE_EMPLOYEE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteEmployee(learn.proto.fullstack.EmployeeRequest request,
        io.grpc.stub.StreamObserver<learn.proto.fullstack.EmployeeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_EMPLOYEE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEmployee(learn.proto.fullstack.EmployeeRequest request,
        io.grpc.stub.StreamObserver<learn.proto.fullstack.Employee> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_EMPLOYEE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EmployeeServiceBlockingStub extends io.grpc.stub.AbstractStub<EmployeeServiceBlockingStub> {
    private EmployeeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     ** client will send one request and
     *The server processes the request, fetches all employees, and sends single single
     *GetAllEmpRes *
     * </pre>
     */
    public learn.proto.fullstack.GetAllEmpRes getAllEmployees(learn.proto.fullstack.Empty request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ALL_EMPLOYEES, getCallOptions(), request);
    }

    /**
     * <pre>
     ** client will send one request and
     *The server processes the request, and sends single single
     *Response *
     * </pre>
     */
    public learn.proto.fullstack.EmployeeResponse createEmployee(learn.proto.fullstack.CreateEmployeeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_EMPLOYEE, getCallOptions(), request);
    }

    /**
     */
    public learn.proto.fullstack.UpdateEmployeeResponse updateEmployee(learn.proto.fullstack.UpdateEmployeeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE_EMPLOYEE, getCallOptions(), request);
    }

    /**
     */
    public learn.proto.fullstack.EmployeeResponse deleteEmployee(learn.proto.fullstack.EmployeeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_EMPLOYEE, getCallOptions(), request);
    }

    /**
     */
    public learn.proto.fullstack.Employee getEmployee(learn.proto.fullstack.EmployeeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_EMPLOYEE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EmployeeServiceFutureStub extends io.grpc.stub.AbstractStub<EmployeeServiceFutureStub> {
    private EmployeeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     ** client will send one request and
     *The server processes the request, fetches all employees, and sends single single
     *GetAllEmpRes *
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<learn.proto.fullstack.GetAllEmpRes> getAllEmployees(
        learn.proto.fullstack.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ALL_EMPLOYEES, getCallOptions()), request);
    }

    /**
     * <pre>
     ** client will send one request and
     *The server processes the request, and sends single single
     *Response *
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<learn.proto.fullstack.EmployeeResponse> createEmployee(
        learn.proto.fullstack.CreateEmployeeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_EMPLOYEE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<learn.proto.fullstack.UpdateEmployeeResponse> updateEmployee(
        learn.proto.fullstack.UpdateEmployeeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE_EMPLOYEE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<learn.proto.fullstack.EmployeeResponse> deleteEmployee(
        learn.proto.fullstack.EmployeeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_EMPLOYEE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<learn.proto.fullstack.Employee> getEmployee(
        learn.proto.fullstack.EmployeeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_EMPLOYEE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_EMPLOYEES = 0;
  private static final int METHODID_CREATE_EMPLOYEE = 1;
  private static final int METHODID_UPDATE_EMPLOYEE = 2;
  private static final int METHODID_DELETE_EMPLOYEE = 3;
  private static final int METHODID_GET_EMPLOYEE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmployeeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmployeeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_EMPLOYEES:
          serviceImpl.getAllEmployees((learn.proto.fullstack.Empty) request,
              (io.grpc.stub.StreamObserver<learn.proto.fullstack.GetAllEmpRes>) responseObserver);
          break;
        case METHODID_CREATE_EMPLOYEE:
          serviceImpl.createEmployee((learn.proto.fullstack.CreateEmployeeRequest) request,
              (io.grpc.stub.StreamObserver<learn.proto.fullstack.EmployeeResponse>) responseObserver);
          break;
        case METHODID_UPDATE_EMPLOYEE:
          serviceImpl.updateEmployee((learn.proto.fullstack.UpdateEmployeeRequest) request,
              (io.grpc.stub.StreamObserver<learn.proto.fullstack.UpdateEmployeeResponse>) responseObserver);
          break;
        case METHODID_DELETE_EMPLOYEE:
          serviceImpl.deleteEmployee((learn.proto.fullstack.EmployeeRequest) request,
              (io.grpc.stub.StreamObserver<learn.proto.fullstack.EmployeeResponse>) responseObserver);
          break;
        case METHODID_GET_EMPLOYEE:
          serviceImpl.getEmployee((learn.proto.fullstack.EmployeeRequest) request,
              (io.grpc.stub.StreamObserver<learn.proto.fullstack.Employee>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class EmployeeServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return learn.proto.fullstack.Schema.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EmployeeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmployeeServiceDescriptorSupplier())
              .addMethod(METHOD_GET_ALL_EMPLOYEES)
              .addMethod(METHOD_CREATE_EMPLOYEE)
              .addMethod(METHOD_UPDATE_EMPLOYEE)
              .addMethod(METHOD_DELETE_EMPLOYEE)
              .addMethod(METHOD_GET_EMPLOYEE)
              .build();
        }
      }
    }
    return result;
  }
}
