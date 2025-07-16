public class rotations {
    blocks[][][] blocksArray = new blocks[7][4][4];

    public rotations() {
        blocksArray[0][0][0].posX = -2;
        blocksArray[0][0][0].posY = -2;
        blocksArray[0][0][0].isBottom = true;
        blocksArray[0][0][0].isLeft = true;
        blocksArray[0][0][0].isRight = false;

        blocksArray[0][0][1].posX = -1;
        blocksArray[0][0][1].posY = -1;
        blocksArray[0][0][1].isBottom = true;
        blocksArray[0][0][1].isLeft = false;
        blocksArray[0][0][1].isRight = false;

        blocksArray[0][0][2].posX = 0;
        blocksArray[0][0][2].posY = 0;
        blocksArray[0][0][2].isBottom = true;
        blocksArray[0][0][2].isLeft = false;
    }

    /*

     * "block3": {
     * "posX": 0,
     * "posY": 0,
     * "isBottom": true,
     * "isLeft": false,
     * "isRight": false
     * },
     * "block4": {
     * "posX": 1,
     * "posY": 1,
     * "isBottom": true,
     * "isLeft": false,
     * "isRight": true
     * }
     * },
     * "lineR2": {
     * "block1": {
     * "posX": 2,
     * "posY": 2,
     * "isBottom": true,
     * "isLeft": true,
     * "isRight": true
     * },
     * "block2": {
     * "posX": 1,
     * "posY": 1,
     * "isBottom": false,
     * "isLeft": true,
     * "isRight": true
     * },
     * "block3": {
     * "posX": 0,
     * "posY": 0,
     * "isBottom": false,
     * "isLeft": true,
     * "isRight": true
     * },
     * "block4": {
     * "posX": -1,
     * "posY": -1,
     * "isBottom": false,
     * "isLeft": true,
     * "isRight": true
     * }
     * }
     * },
     * "L": {
     * "LR1": {
     * "block1": {
     * "posX": -2,
     * "posY": 0,
     * "isBottom": false,
     * "isLeft": true,
     * "isRight": false
     * },
     * "block2": {
     * "posX": -1,
     * "posY": 0,
     * "isBottom": true,
     * "isLeft": false,
     * "isRight": false
     * },
     * "block3": {
     * "posX": 0,
     * "posY": 0,
     * "isBottom": true,
     * "isLeft": false,
     * "isRight": true
     * },
     * "block4": {
     * "posX": -2,
     * "posY": 1,
     * "isBottom": true,
     * "isLeft": true,
     * "isRight": true
     * }
     * },
     * "LR2": {
     * "block1": {
     * "posX": 1,
     * "posY": -1,
     * "isBottom": false,
     * "isLeft": false,
     * "isRight": true
     * },
     * "block2": {
     * "posX": 0,
     * "posY": 0,
     * "isBottom": false,
     * "isLeft": true,
     * "isRight": true
     * },
     * "block3": {
     * "posX": -1,
     * "posY": 1,
     * "isBottom": true,
     * "isLeft": true,
     * "isRight": true
     * },
     * "block4": {
     * "posX": 0,
     * "posY": -2,
     * "isBottom": true,
     * "isLeft": true,
     * "isRight": false
     * }
     * },
     * "LR3": {
     * "block1": {
     * "posX": 1,
     * "posY": 1,
     * "isBottom": true,
     * "isLeft": false,
     * "isRight": true
     * },
     * "block2": {
     * "posX": -1,
     * "posY": 1,
     * "isBottom": true,
     * "isLeft": false,
     * "isRight": false
     * },
     * "block3": {
     * "posX": -2,
     * "posY": 0,
     * "isBottom": true,
     * "isLeft": true,
     * "isRight": false
     * },
     * "block4": {
     * "posX": 1,
     * "posY": 1,
     * "isBottom": false,
     * "isLeft": true,
     * "isRight": true
     * }
     * },
     * "LR4": {
     * "block1": {
     * "posX": -2,
     * "posY": 0,
     * "isBottom": true,
     * "isLeft": true,
     * "isRight": false
     * },
     * "block2": {
     * "posX": -1,
     * "posY": -1,
     * "isBottom": false,
     * "isLeft": true,
     * "isRight": true
     * },
     * "block3": {
     * "posX": 0,
     * "posY": -2,
     * "isBottom": false,
     * "isLeft": true,
     * "isRight": true
     * },
     * "block4": {
     * "posX": -1,
     * "posY": 1,
     * "isBottom": true,
     * "isLeft": false,
     * "isRight": true
     * }
     * }
     * },
     * "J": {
     * "JR1": {
     * "block1":{
     * 
     * }
     * }
     * }
     * }
     */

}
