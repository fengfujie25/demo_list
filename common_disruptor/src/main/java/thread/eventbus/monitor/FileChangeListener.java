package thread.eventbus.monitor;

import thread.eventbus.Subscribe;

/**
 * @author fujie.feng
 * @Date 2020-04-09
 */
public class FileChangeListener {

    @Subscribe
    public void onChange(FileChangeEvent event) {
        System.out.printf("%s-%s\n", event.getPath(), event.getKind());
    }
}
