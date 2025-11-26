package ShiftNDrift;
import ShiftNDrift.ActionResolver;

    public class DesktopActionResolver implements ActionResolver {
        @Override
        public boolean isFullScreen() {
            return false; // Desktop app starts windowed by default
        }

        @Override
        public boolean showMouseCursor() {
            return true; // Mouse cursor should be visible on desktop
        }

        @Override
        public boolean isFreePlay() {
            return true; // Assume free play mode on desktop
        }

        @Override
        public int livesPerCredit() {
            return 5; // Example default value
        }

        @Override
        public int continuesPerCredit() {
            return 3; // Example default value
        }

        @Override
        public int menuScreenTimer() {
            return 30; // Time in seconds/frames
        }

        @Override
        public int attractScreenTimer() {
            return 60; // Time in seconds/frames
        }

        @Override
        public int limitTimer() {
            return 180; // Time in seconds/frames
        }

        @Override
        public int warningTimer() {
            return 10; // Time in seconds/frames
        }

        @Override
        public int continueTimer() {
            return 10; // Time in seconds/frames
        }

        @Override
        public boolean showFPS() {
            return true; // Useful for debugging on desktop
        }

        @Override
        public boolean playMusic() {
            return true; // Default to having music on
        }

        @Override
        public boolean showDebug() {
            return true; // Useful for debugging on desktop
        }

        @Override
        public boolean unlockAll() {
            return false; // Don't unlock everything by default
        }
    }
