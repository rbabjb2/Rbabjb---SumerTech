
//import org.json.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class block {
    File file = new File("blocks.txt");
    private String blockType;
    public int blockNumber;
    public int posX;
    public int posY;
    public int rotation;
    private int screenSizeX;
    private int screenSizeY;
    public boolean isBottom;
    public boolean isLeft;
    public boolean isRight;

    public void reset(String type) {
        rotation = 1;
        this.blockType = type;
        isBottom = false;
        isLeft = false;
        isRight = false;
        if (this.blockType == "square") {
            this.posX = screenSizeX / 2;
            this.posY = 0;

        } else if (this.blockType == "line") {
            if (blockNumber == 1) {
                this.posX = (screenSizeX / 2) - 2;
                this.posY = 0;
                isBottom = true;
                isLeft = true;
            } else if (blockNumber == 2) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 0;
                isBottom = true;
            } else if (blockNumber == 3) {
                this.posX = screenSizeX / 2;
                this.posY = 0;
                isBottom = true;
            } else if (blockNumber == 4) {
                this.posX = (screenSizeX / 2) + 1;
                this.posY = 0;
                isBottom = true;
                isRight = true;
            } else {
                System.out.println("For some reason block number = " + blockNumber);
                System.exit(0);
            }

        } else if (this.blockType.equalsIgnoreCase("l")) {
            if (blockNumber == 1) {
                this.posX = (screenSizeX / 2) - 2;
                this.posY = 0;
                isLeft = true;
            } else if (blockNumber == 2) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 0;
                isBottom = true;
            } else if (blockNumber == 3) {
                this.posX = screenSizeX / 2;
                this.posY = 0;
                isBottom = true;
                isRight = true;
            } else if (blockNumber == 4) {
                this.posX = (screenSizeX / 2) - 2;
                this.posY = 1;
                isBottom = true;
                isLeft = true;
                isRight = true;
            } else {
                System.out.println("For some reason block number = " + blockNumber);
                System.exit(0);
            }

        } else if (this.blockType == "cube") {
            if (blockNumber == 1) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 0;
                isLeft = true;
            } else if (blockNumber == 2) {
                this.posX = (screenSizeX / 2);
                this.posY = 0;
                isRight = true;
            } else if (blockNumber == 3) {
                this.posX = screenSizeX / 2 - 1;
                this.posY = 1;
                isBottom = true;
                isLeft = true;
            } else if (blockNumber == 4) {
                this.posX = (screenSizeX / 2);
                this.posY = 1;
                isBottom = true;
                isRight = true;
            } else {
                System.out.println("For some reason block number = " + blockNumber);
                System.exit(0);
            }

        } else if (this.blockType.equalsIgnoreCase("j")) {
            if (blockNumber == 1) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 0;
                isLeft = true;
                isBottom = true;
            } else if (blockNumber == 2) {
                this.posX = (screenSizeX / 2);
                this.posY = 0;
                isBottom = true;
            } else if (blockNumber == 3) {
                this.posX = screenSizeX / 2 + 1;
                this.posY = 0;
                isRight = true;
            } else if (blockNumber == 4) {
                this.posX = (screenSizeX / 2) + 1;
                this.posY = 1;
                isBottom = true;
                isRight = true;
                isLeft = true;
            } else {
                System.out.println("For some reason block number = " + blockNumber);
                System.exit(0);
            }

        } else if (this.blockType.equalsIgnoreCase("s")) {
            if (blockNumber == 1) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 0;
                isLeft = true;
            } else if (blockNumber == 2) {
                this.posX = (screenSizeX / 2);
                this.posY = 0;
                isBottom = true;
                isRight = true;
            } else if (blockNumber == 3) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 1;
                isRight = true;
                isBottom = true;
            } else if (blockNumber == 4) {
                this.posX = (screenSizeX / 2) - 2;
                this.posY = 1;
                isBottom = true;

                isLeft = true;
            } else {
                System.out.println("For some reason block number = " + blockNumber);
                System.exit(0);
            }

        } else if (this.blockType.equalsIgnoreCase("t")) {
            if (blockNumber == 1) {
                this.posX = (screenSizeX / 2) - 2;
                this.posY = 0;
                isLeft = true;
                isBottom = true;
            } else if (blockNumber == 2) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 0;
            } else if (blockNumber == 3) {
                this.posX = screenSizeX / 2;
                this.posY = 0;
                isRight = true;
                isBottom = true;
            } else if (blockNumber == 4) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 1;
                isBottom = true;
                isRight = true;
                isLeft = true;
            } else {
                System.out.println("For some reason block number = " + blockNumber);
                System.exit(0);
            }

        } else if (blockType.equalsIgnoreCase("z")) {
            if (blockNumber == 1) {
                this.posX = (screenSizeX / 2) - 1;
                this.posY = 0;
                isLeft = true;
                isBottom = true;
            } else if (blockNumber == 2) {
                this.posX = (screenSizeX / 2);
                this.posY = 0;
                isRight = true;
            } else if (blockNumber == 3) {
                this.posX = screenSizeX / 2;
                this.posY = 1;
                isLeft = true;
                isBottom = true;
            } else if (blockNumber == 4) {
                this.posX = (screenSizeX / 2) + 1;
                this.posY = 1;
                isBottom = true;
                isRight = true;
            } else {
                System.out.println("For some reason block number = " + blockNumber);
                System.exit(0);
            }

        } else {
            System.out.println("Please check your block type, its " + blockType);
            System.exit(0);
        }
    }

    // needs wall detection
    public void move(String direction) {
        if (direction == "down") {
            this.posY++;
        } else if (direction == "left") {
            this.posX--;
        } else if (direction == "right") {
            this.posX++;
        } else {
            System.out.println("Error: Please check the move script and where you call it.");
        }
    }

    public static void main(String[] args) {
        // JSONObject jsonTest = new JSONObject("blocks.json");
        // System.out.println(jsonTest.getJSONObject("jsonTest").getString("temp")
    }

    public int[] getPos() {
        int[] pos = new int[2];
        pos[0] = this.posX;
        pos[1] = this.posY;
        return pos;
    }

    public void screenSizeSet(int screenSizeX, int screenSizeY) {
        this.screenSizeX = screenSizeX;
        this.screenSizeY = screenSizeY;
    }

    public String getType() {
        return this.blockType;
    }

    public block() {
        isLeft = false;
        isRight = false;
        isBottom = false;
        rotation = 1;

    }

    public void setBlockNumber(int number) {
        blockNumber = number;
    }

    private void scan(Scanner scanner, int startingLine) {
        for (int i = 1; i < startingLine; i++) {
            scanner.nextLine();
        }
    }

    public void rotate() {
        rotation++;
        try {
            Scanner scanner = new Scanner(file);
            if (this.blockType == "cube") {
                // Do nothing if cube is rotated.
            } else if (this.blockType == "line") {
                if (rotation == 1) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 1);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 7);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 13);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 19);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 2) {
                    rotation = 0;
                    if (blockNumber == 1) {
                        this.scan(scanner, 25);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 31);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 37);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 43);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                }
            } else if (this.blockType.equalsIgnoreCase("l")) {
                if (rotation == 1) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 49);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 55);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 61);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 67);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 2) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 73);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 79);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 85);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 91);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 3) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 97);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 103);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 109);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 115);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 4) {
                    rotation = 0;
                    if (blockNumber == 1) {
                        this.scan(scanner, 121);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 127);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 133);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 139);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                }

            } else if (this.blockType.equalsIgnoreCase("j")) {
                if (rotation == 1) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 145);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 151);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 157);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 163);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 2) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 169);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 175);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 181);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 187);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 3) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 193);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 199);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 205);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 211);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 4) {
                    rotation = 0;
                    if (blockNumber == 1) {
                        this.scan(scanner, 217);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 223);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 229);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 235);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                }

            } else if (this.blockType.equalsIgnoreCase("s")) {

                if (rotation == 1) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 241);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 247);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 253);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 259);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 2) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 265);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 271);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 277);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 283);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 3) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 289);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 295);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 301);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 307);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 4) {
                    rotation = 0;
                    if (blockNumber == 1) {
                        this.scan(scanner, 313);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 319);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 325);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 331);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                }

            } else if (this.blockType.equalsIgnoreCase("z")) {
                if (rotation == 1) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 433);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 439);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 445);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 451);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 2) {
                    if (blockNumber == 1) {
                        this.scan(scanner,457 );
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 463);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 469);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 475);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 3) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 481);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 487);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 493);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 499);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 4) {
                    rotation = 0;
                    if (blockNumber == 1) {
                        this.scan(scanner, 505);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 511);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 517);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 523);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                }

            } else if (this.blockType.equalsIgnoreCase("t")) {

                if (rotation == 1) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 337);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 343);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 349);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 355);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 2) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 361);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 367);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 373);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 379);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 3) {
                    if (blockNumber == 1) {
                        this.scan(scanner, 385);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 391);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 397);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 403);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                } else if (rotation == 4) {
                    rotation = 0;
                    if (blockNumber == 1) {
                        this.scan(scanner, 409);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 2) {
                        this.scan(scanner, 415);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 3) {
                        this.scan(scanner, 421);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    } else if (blockNumber == 4) {
                        this.scan(scanner, 427);
                        posX = posX + Integer.parseInt(scanner.nextLine());
                        posY = posY + Integer.parseInt(scanner.nextLine());
                        isBottom = Boolean.parseBoolean(scanner.nextLine());
                        isLeft = Boolean.parseBoolean(scanner.nextLine());
                        isRight = Boolean.parseBoolean(scanner.nextLine());
                    }
                }

            }
            scanner.close();
        } catch (FileNotFoundException bob) {
            bob.printStackTrace();
        }
    }

}
