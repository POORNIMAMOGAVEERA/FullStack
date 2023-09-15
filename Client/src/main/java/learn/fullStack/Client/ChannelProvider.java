package learn.fullStack.Client;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ChannelProvider {
    private static ManagedChannel channel;

    public static synchronized ManagedChannel getChannel() {
        if (channel == null) {
            channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                    .usePlaintext()
                    .build();
        }
        return channel;
    }

//    public static synchronized void shutdownChannel() {
//        if (channel != null && !channel.isShutdown()) {
//            channel.shutdown();
//        }
//    }
}
