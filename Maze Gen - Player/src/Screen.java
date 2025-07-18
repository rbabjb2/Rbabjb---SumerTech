import java.util.ArrayList;
import java.awt.Color;

public class Screen {
    int[][] map;
    ArrayList<Texture> textures;
    int width, height, mazeSize;

    public Screen(int[][] maze, ArrayList<Texture> textures, int width, int height, int mazeSize) {
        this.map = maze;
        this.textures = textures;
        this.width = width;
        this.height = height;
        this.mazeSize = mazeSize;

    }

    public void update(Camera camera, int[] pixels) {
        for (int i = 0; i < pixels.length / 2; i++) {
            pixels[i] = Color.DARK_GRAY.getRGB();
        }
        for (int i = pixels.length / 2; i < pixels.length; i++) {
            pixels[i] = Color.GRAY.getRGB();
        }
        for (int x = 0; x < width; x++) {
            double camX = (x * 2) / (double) width - 1;
            double rayDirX = camera.dirX + (camera.planeX * camX);
            double rayDirY = camera.dirY + (camera.planeY * camX);
            int mapX = (int) camera.posX;
            int mapY = (int) camera.posY;
            double sideDistanceX, sideDistanceY;
            double deltaDistanceX = Math.sqrt(1 + (rayDirY * rayDirY) / (rayDirX * rayDirX));
            double deltaDistanceY = Math.sqrt(1 + (rayDirX * rayDirX) / (rayDirY * rayDirY));
            double purpWallDistance;
            int stepX, stepY;
            boolean hit = false;
            int side = 0;
            if (rayDirX < 0) {
                stepX = -1;
                sideDistanceX = (camera.posX - mapX) * deltaDistanceX;
            } else {
                stepX = 1;
                sideDistanceX = ((mapX + 1) - (camera.posX)) * deltaDistanceX;
            }
            if (rayDirY < 0) {
                stepY = -1;
                sideDistanceY = (camera.posY - mapY) * deltaDistanceY;
            } else {
                stepY = 1;
                sideDistanceY = ((mapY + 1) - (camera.posY)) * deltaDistanceY;
            }
            while (hit == false) {
                if (sideDistanceX < sideDistanceY) {
                    sideDistanceX += deltaDistanceX;
                    mapX += stepX;
                    side = 0;
                } else {
                    sideDistanceY += deltaDistanceY;
                    mapY += stepY;
                    side = 1;
                }
                if (map[mapX][mapY] != 0) {
                    hit = true;
                }
            }
            if (side == 0) {
                purpWallDistance = Math.abs(((mapX - camera.posX) + (1 - stepX) / 2) / rayDirX);
            } else {
                purpWallDistance = Math.abs(((mapY - camera.posY) + (1 - stepY) / 2) / rayDirY);
            }
            int lineHeight;
            if (purpWallDistance > 0) {
                lineHeight = Math.abs((int) (height / purpWallDistance));
            } else {
                lineHeight = height;
            }
            int drawStart = (-lineHeight / 2) + height / 2;
            if (drawStart < 0) {
                drawStart = 0;
            }
            int drawEnd = (lineHeight / 2) + height / 2;
            if (drawEnd >= height) {
                drawEnd = height - 1;
            }
            int textureNum = map[mapX][mapY] - 1;
            double wallX;
            if (side == 1) {
                wallX = (camera.posX + ((mapY - camera.posY + (1 - stepY) / 2) / rayDirY) * rayDirX);
            } else {
                wallX = (camera.posY + ((mapX - camera.posX + (1 - stepX) / 2) / rayDirX) * rayDirY);
            }
            wallX -= Math.floor(wallX);
            int textureX = (int) (wallX * (textures.get(textureNum).size));
            if (side == 0 && rayDirX > 0) {
                textureX = textures.get(textureNum).size - textureX - 1;
            }
            if (side == 1 && rayDirY < 0) {
                textureX = textures.get(textureNum).size - textureX - 1;
            }
            for (int y = drawStart; y < drawEnd; y++) {
                int color;
                int textureY = (((y * 2 - height + lineHeight) << 6) / lineHeight) / 2;
                if (side == 0) {
                    color = textures.get(textureNum).pixels[textureX + (textureY * textures.get(textureNum).size)];
                } else {
                    color = (textures.get(textureNum).pixels[textureX
                            + (textureY * textures.get(textureNum).size)] >> 1) & 8355711;
                }
                pixels[x + y * width] = color;
            }
        }
    }
}
