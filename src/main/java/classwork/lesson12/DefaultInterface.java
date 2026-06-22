package classwork.lesson12;

import java.util.ArrayList;
import java.util.List;

public class DefaultInterface {

    public static void main(String[] args) {

        List<RemoteControllable> remotes = new ArrayList<>();

        remotes.add(new RemoteControlTV());
        remotes.add(new RemoteControlRadio());

        for (RemoteControllable remote : remotes) {
            remote.turnOn();
            remote.switchChannel();
            remote.switchVolume();
        }
    }

    public interface RemoteControllable {
        default void turnOn(){
            System.out.println("Turn on");
        }

        void switchChannel();

        void switchVolume();
    }

    public static class RemoteControlTV implements RemoteControllable {

        @Override
        public void turnOn() {
            System.out.println("Turn the TV on");
        }

        @Override
        public void switchChannel() {
            System.out.println("Switch TV channel");
        }

        @Override
        public void switchVolume() {
            System.out.println("Switch TV Volume");
        }
    }

    public static class RemoteControlRadio implements RemoteControllable {
        @Override
        public void switchChannel() {
            System.out.println("Turning knob");
        }

        @Override
        public void switchVolume() {
            System.out.println("Turning knob");
        }
    }
}
