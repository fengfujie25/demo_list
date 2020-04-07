package thread.future;


import java.util.concurrent.Future;

public interface FutureService<In, Out> {

    Future<?> submit(Runnable runnable);

    Future<Out> submit(Task<In, Out> task, In in);

    Future<Out> submit(Task<In, Out> task, In in, CallBack<Out> callback);

    static <T,R> FutureService<T, R> newService(){
        return new FutureServiceImpl<>();
    }
}


