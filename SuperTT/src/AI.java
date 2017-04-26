/*
AI gets called by GameManager who uses the makeMove method
GameManager sends whatever the last move was in string form
AI goes through the algorithm and returns the spot we want to move to as a string
 */


/**
 * @author cnelt
 */

public class AI {    
    String[] markedSpots = new String[25];
    private int theirSpot;
    private int columnCount = 0;
    private  int rowCount = 0;
    private int backDiagCount = 0;
    private int forwardDiagCount = 0;
    private int backDiagSpots = 0;
    private int forwardDiagSpots = 0;
    
    private final String theirShape = "o";
    private final String myShape = "x";
    private int mySpot;
    
    int makeMove(int recievedSpot){        
//        this.theirSpot = Integer.parseInt(recievedSpot);
        this.theirSpot = recievedSpot;
        if(recievedSpot == -99){//no one has went yet and AI goes first
            markedSpots[12] = myShape;
            mySpot = 12;
        }
        else{
            columnCount = 0;
            rowCount = 0;
            backDiagCount = 0;
            forwardDiagCount = 0;
            backDiagSpots = 0;
            forwardDiagSpots = 0;
            //zero out everything
            this.markedSpots[this.theirSpot] = theirShape; //mark enemy spot
            this.countVerticle();
            this.countHorizontal();
            this.countBackDiagonal();
            this.countForwardDiagonal(); //get highest counts from each direction of enemy variables
            this.markSpot(); //call method that marks our spot
        }
        return mySpot;
    }

    private void countVerticle() { //counts enemy variables in the column
        int colCount = this.theirSpot;     

        while(colCount >= 0){
            if(this.markedSpots[colCount] == this.myShape){//we hit our own shape so return
                this.columnCount = 0;
                return;
            }
            else{
                if(this.markedSpots[colCount] == this.theirShape){ //they went here so increase count
                    this.columnCount++;
                }
                colCount -= 5;
            }
        }
        colCount = this.theirSpot + 5; //reset the count
        while(colCount <= 24){
            if(this.markedSpots[colCount] == this.myShape){//we hit our own shape so return
                this.columnCount = 0;
                return;
            }
            else{
                if(this.markedSpots[colCount] == this.theirShape){//they went here so increase count
                    this.columnCount++;
                }
                colCount += 5;
            }
        }        
    }

    private void countHorizontal() {//counts enemy variables in the row
        int horCount = this.theirSpot - 1;       
        this.rowCount++;
        
        while(horCount >= 0){
            if(horCount == 4|| horCount == 9 || horCount == 14 || horCount == 19){
                break;
            }
            else
                if(this.markedSpots[horCount] == this.myShape){//we hit our own shape so return
                    this.rowCount = 0;
                    return;
                }
                else{
                    if(this.markedSpots[horCount] == this.theirShape){//they went here so increase count
                        this.rowCount++;
                    }
                    horCount--;
                }
        }
        horCount = this.theirSpot + 1; //reset the count
        if( horCount == 5 ||  horCount == 10 ||  horCount == 15 ||  horCount == 20){
            return;
        }
        while(horCount <= 24){
            if( horCount == 5 ||  horCount == 10 ||  horCount == 15 ||  horCount == 20){
                break;
            }
            else
                if(this.markedSpots[horCount] == this.myShape){//we hit our own shape so return
                    this.rowCount = 0;
                    return;
                }
                else{
                    if(this.markedSpots[horCount] == this.theirShape){//they went here so increase count
                        this.rowCount++;
                    }
                    horCount++;
                }
        }  
    }

    private void countBackDiagonal() {//count the top left to bottom right diagonal
        int diagCount = this.theirSpot;
        
        if(diagCount == 0 || diagCount == 6 || diagCount == 12 || diagCount == 18 || diagCount == 24){ //if it's not on main diagonal skip it
            while(diagCount >= 0){
                if(this.markedSpots[diagCount] == this.myShape){
                    this.backDiagCount = 0;
                    return;
                }
                else{
                    if(this.markedSpots[diagCount] == this.theirShape)
                        this.backDiagCount++;
                    diagCount -= 6;
                }                
            }
            diagCount = this.theirSpot + 6;
            while(diagCount <= 24){
                if(this.markedSpots[diagCount] == this.myShape){//we already have a spot on the diagonal, skip the count
                    this.backDiagCount = 0;
                    return;
                }
                else{
                    if(this.markedSpots[diagCount] == this.theirShape)//they marked a spot so increase the count
                        this.backDiagCount++;
                    diagCount += 6;
                }
            }
        }else{
            return;
        }
    }

    private void countForwardDiagonal() {//count the bottom left to top right diagonal
        int diagCount = this.theirSpot;
        
        if(diagCount == 20 || diagCount == 16 || diagCount == 12 || diagCount == 8 || diagCount == 4) {//if it's not on main diagonal skip it
            while(diagCount >= 0){
                if(this.markedSpots[diagCount] == this.myShape){//we already have a spot on the diagonal, skip the count
                    this.forwardDiagCount = 0;
                    return;
                }
                else{
                    if(this.markedSpots[diagCount] == this.theirShape)//they marked a spot so increase the count
                        this.forwardDiagCount++;
                    diagCount -= 4;
                }                
            }
            diagCount = this.theirSpot + 4;
            while(diagCount <= 24){
                if(this.markedSpots[diagCount] == this.myShape){//we already have a spot on the diagonal, skip the count
                    this.forwardDiagCount = 0;
                    return;
                }
                else{
                    if(this.markedSpots[diagCount] == this.theirShape)//they marked a spot so increase the count
                        this.forwardDiagCount++;
                    diagCount += 4;
                }                
            }
        }
        else{
            return;
        }
    }

    private void markSpot() {//finds correct spot to mark
        int largestCount = 0;
        if(this.columnCount > this.rowCount)//find row/column/diagonal that has highest enemy spots
            largestCount = this.columnCount;
        else
            largestCount = this.rowCount;
        
        if(largestCount < this.backDiagCount)
            largestCount = this.backDiagCount;
        else if (largestCount < this.forwardDiagCount)
            largestCount = this.forwardDiagCount;
        
        if(largestCount == 0){ //there is no way left to win
            drawGame();
        }
        else{ //cut off their move
            if(largestCount == this.columnCount)
                markColumnSpot();
            else if(largestCount == this.rowCount)
                markRowSpot();
            else if(largestCount == this.backDiagCount)
                markBackDiagSpot();
            else if(largestCount == this.forwardDiagCount)
                markForwardDiagSpot();                
        }        
    }

    private void markColumnSpot() {//column has most amount of enemy moves so put a mark in the column
        int colSpot = this.theirSpot;
        
        while(colSpot >= 0){//loop towards the top of the column until we find open spot
            if(this.markedSpots[colSpot] == this.myShape || this.markedSpots[colSpot] == this.theirShape)//there is a shape here so move to next spot
                colSpot -= 5;
            else{
                this.markedSpots[colSpot] = this.myShape;
//                this.mySpot = Integer.toString(colSpot);
                this.mySpot = colSpot;
                return;
            }
        }
        colSpot = this.theirSpot + 5;
        while(colSpot <= 24){//loop to bottom of column until we find open spot
            if(this.markedSpots[colSpot] == this.myShape || this.markedSpots[colSpot] == this.theirShape)//there is a shape here so move to next spot
                colSpot += 5;
            else{
                this.markedSpots[colSpot] = this.myShape;
//                this.mySpot = Integer.toString(colSpot);
                this.mySpot = colSpot;
                return;
            }
        }
    }

    private void markRowSpot() {//row has most amount of enemy moves so put a mark in the row
        int rowCount = 0;
        int rowSpot = this.theirSpot - 1;
        
        while(rowSpot >= 0){ //loop to left side of row until we find open spot
            if(rowSpot == 4 || rowSpot == 9 || rowSpot == 14 || rowSpot == 19 || rowSpot == 24)//hit a new row so count from other end
                break;
            else{
                if(this.markedSpots[rowSpot] == this.myShape || this.markedSpots[rowSpot] == this.theirShape)//there is a shape here so move to next spot
                    rowSpot --;
                else{
                    this.markedSpots[rowSpot] = this.myShape;
//                    this.mySpot = Integer.toString(rowSpot);
                    this.mySpot = rowSpot;
                    return;
                }
            }
        }
        rowSpot = this.theirSpot + 1;
        while(rowSpot <= 24){//loop to right side of row until we find open spot
            if(rowSpot == 5 || rowSpot == 10 || rowSpot == 15 || rowSpot == 20)//hit a new row so break loop
                break;
            else{
                if(this.markedSpots[rowSpot] == this.myShape || this.markedSpots[rowSpot] == this.theirShape)//there is a shape here so move to next spot
                    rowSpot ++;
                else{
                    this.markedSpots[rowSpot] = this.myShape;
//                    this.mySpot = Integer.toString(rowSpot);
                    this.mySpot = rowSpot;
                    return;
                }
            }
        }
    }

    private void markBackDiagSpot() {//make our move along the diagonal from top left to bottom right (like \)
        int diagSpot = 0;
        
        while(diagSpot <= 24){
            if(this.markedSpots[diagSpot] == this.myShape || this.markedSpots[diagSpot] == this.theirShape)//there is a shape here so move to next spot
                diagSpot += 6;
            else{
                this.markedSpots[diagSpot] = this.myShape;
//                this.mySpot = Integer.toString(diagSpot);
                this.mySpot = diagSpot;
            }
        }
    }

    private void markForwardDiagSpot() {//make our move along the diagonal from bottom left to top right (like /)
        int diagSpot = 4;
        
        while(diagSpot <= 20){
            if(this.markedSpots[diagSpot] == this.myShape || this.markedSpots[diagSpot] == this.theirShape)//there is a shape here so move to next spot
                diagSpot += 4;
            else{
                this.markedSpots[diagSpot] = this.myShape;
//                this.mySpot = Integer.toString(diagSpot);
                this.mySpot = diagSpot;
            }
        }
    }

    private void drawGame() {//no one can win so just find next available spot along the game board
        for(int i = 0; i < 25; i++){
            if(this.markedSpots[i] == this.theirShape || this.markedSpots[i] == this.myShape)//if there is a shape here skip it
                this.rowCount++;
            else{ //mark o and break
                this.markedSpots[i] = this.myShape;
//                this.mySpot = Integer.toString(i);
                this.mySpot = i;
                return;
            }            
        }
    }
}
