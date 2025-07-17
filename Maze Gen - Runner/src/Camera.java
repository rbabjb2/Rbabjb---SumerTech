import java.awt.event.*;

public class Camera implements KeyListener {
    public double posX, posY, dirY, dirX, planeY, planeX;
    public boolean left, right, forward, back;
    public int updateRan = 0;
    public final double MOVE_SPEED = 0.05;
    // wass 0.1
    public final double ROTATION_SPEED = 0.05;
    public int[][] map;

    public Camera(double pX, double pY, double dX, double dY, double plX, double plY, int[][] map) {
        posX = pX;
        posY = pY;
        dirX = dX;
        dirY = dY;
        planeX = plX;
        planeY = plY;
        this.map = map;
    }

    public void update() {
        if (forward) {
            if (updateRan < 20) {
                posX += dirX * MOVE_SPEED;
                updateRan++;
                posY += dirY * MOVE_SPEED;
            } else {
                forward = false;
                updateRan = 0;
                // Stops moving forward
            }

        }

        if (right) {
            if (updateRan < 31) {
                double oldDirX = dirX;
                dirX = dirX * Math.cos(ROTATION_SPEED) - dirY * Math.sin(ROTATION_SPEED);
                dirY = oldDirX * Math.sin(ROTATION_SPEED) + dirY * Math.cos(ROTATION_SPEED);
                double oldPlaneX = planeX;
                planeX = planeX * Math.cos(ROTATION_SPEED) - planeY *
                        Math.sin(ROTATION_SPEED);
                planeY = oldPlaneX * Math.sin(ROTATION_SPEED) + planeY *
                        Math.cos(ROTATION_SPEED);
                updateRan++;
            } else {
                right = false;
                updateRan = 0;
                dirX = Math.round(dirX);
                dirY = Math.round(dirY);

                if (dirX == 0 && dirY == 1) {
                    planeX = -0.66;
                    planeY = 0.0;
                } else if (dirX == -1 && dirY == 0) {
                    planeX = 0.0;
                    planeY = -0.66;
                } else if (dirX == 0 && dirY == -1) {
                    planeX = 0.66;
                    planeY = 0.0;
                } else {
                    planeX = 0.0;
                    planeY = 0.66;
                }

                // System.out.println("PlaneX is " + planeX);
                // System.out.println("PlaneY is " + planeY);
                // System.out.println("dirX is " + dirX);
                // System.out.println("dirY is " + dirY);

            }

        }

        if (left) {
            if (updateRan < 31) {
                double oldDirX = dirX;
                dirX = dirX * Math.cos(-ROTATION_SPEED) - dirY * Math.sin(-ROTATION_SPEED);
                dirY = oldDirX * Math.sin(-ROTATION_SPEED) + dirY *
                        Math.cos(-ROTATION_SPEED);
                double oldPlaneX = planeX;
                planeX = planeX * Math.cos(-ROTATION_SPEED) - planeY *
                        Math.sin(-ROTATION_SPEED);
                planeY = oldPlaneX * Math.sin(-ROTATION_SPEED) + planeY *
                        Math.cos(-ROTATION_SPEED);
                updateRan++;
            } else {
                left = false;
                updateRan = 0;
                dirX = Math.round(dirX);
                dirY = Math.round(dirY);
                if (dirX == 0 && dirY == 1) {
                    planeX = -0.66;
                    planeY = 0.0;
                } else if (dirX == -1 && dirY == 0) {
                    planeX = 0.0;
                    planeY = -0.66;
                } else if (dirX == 0 && dirY == -1) {
                    planeX = 0.66;
                    planeY = 0.0;
                } else {
                    planeX = -0.0;
                    planeY = 0.66;
                }
            }
        }

        if (back) {
            posX -= dirX * MOVE_SPEED;
            posY -= dirY * MOVE_SPEED;
            updateRan++;
        }
    }

    public void moveUp() {
        posY -= 0.1;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
