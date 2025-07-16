import java.awt.event.*;

public class Camera implements KeyListener {
    public double posX, posY, dirY, dirX, planeY, planeX;
    public boolean left, right, forward, back;
    public final double MOVE_SPEED = 0.08;
    //wass 0.08
    public final double ROTATION_SPEED = 0.045;
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
            if (map[(int) (posX + (dirX * MOVE_SPEED))][(int) posY] == 0) {
                posX += dirX * MOVE_SPEED;
            }
            if (map[(int) posX][(int) (posY + (dirY * MOVE_SPEED))] == 0) {
                posY += dirY * MOVE_SPEED;
            }

        }

        if (left) {
            double oldDirX = dirX;
            dirX = dirX * Math.cos(ROTATION_SPEED) - dirY * Math.sin(ROTATION_SPEED);
            dirY = oldDirX * Math.sin(ROTATION_SPEED) + dirY * Math.cos(ROTATION_SPEED);
            double oldPlaneX = planeX;
            planeX = planeX * Math.cos(ROTATION_SPEED) - planeY *
                    Math.sin(ROTATION_SPEED);
            planeY = oldPlaneX * Math.sin(ROTATION_SPEED) + planeY *
                    Math.cos(ROTATION_SPEED);

        }

        if (right) {
            double oldDirX = dirX;
            dirX = dirX * Math.cos(-ROTATION_SPEED) - dirY * Math.sin(-ROTATION_SPEED);
            dirY = oldDirX * Math.sin(-ROTATION_SPEED) + dirY *
                    Math.cos(-ROTATION_SPEED);
            double oldPlaneX = planeX;
            planeX = planeX * Math.cos(-ROTATION_SPEED) - planeY *
                    Math.sin(-ROTATION_SPEED);
            planeY = oldPlaneX * Math.sin(-ROTATION_SPEED) + planeY *
                    Math.cos(-ROTATION_SPEED);
        }

        if (back) {
            if (map[(int) (posX - (dirX * MOVE_SPEED))][(int) posY] == 0 || map[(int) (posX - (dirX * MOVE_SPEED))][(int) posY] == 5) {
                posX -= dirX * MOVE_SPEED;
            }
            if (map[(int) posX][(int) (posY - (dirY * MOVE_SPEED))] == 0 || map[(int) posX][(int) (posY - (dirY * MOVE_SPEED))] == 5) {
                posY -= dirY * MOVE_SPEED;
            }
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
            case KeyEvent.VK_W:
                forward = true;
                break;
            case KeyEvent.VK_S:
                back = true;
                break;
            case KeyEvent.VK_A:

                left = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W:
                forward = false;
                break;
            case KeyEvent.VK_S:
                back = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
