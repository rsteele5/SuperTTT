/*
AI gets called by GameManager who uses the makeMove method
GameManager sends whatever the last move was in string form
AI goes through the algorithm and returns the spot we want to move to as a string
 */
package testai;

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
    
    private String theirShape = "o";
    private String myShape = "x";
    private String mySpot;
    
    String makeMove(String recievedSpot){        
        this.theirSpot = Integer.parseInt(recievedSpot);
        if("-1".equals(recievedSpot)){//no one has went yet and AI goes first
            markedSpots[12] = myShape;
            mySpot = "12";
        }
        else{
            columnCount = 0;
            rowCount = 0;
            backDiagCount = 0;
            forwardDiagCount = 0;
            backDiagSpots = 0;
            forwardDiagSpots = 0;
            //zero out everything
            this.markedSpots[this.theirSpot] = theirShape;
            this.countVerticle();
            this.countHorizontal();
            this.countBackDiagonal();
            this.countForwardDiagonal();
            this.markSpot();
        }
        return mySpot;
    }

    private void countVerticle() {
        int colCount = this.theirSpot;     

        while(colCount >= 0){
            if(this.markedSpots[colCount] == this.myShape){//we hit our own shape so return
                this.columnCount = 0;
                return;
            }
            else{
                if(this.markedSpots[colCount] == this.theirShape){
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
                if(this.markedSpots[colCount] == this.theirShape){
                    this.columnCount++;
                }
                colCount += 5;
            }
        }        
    }

    private void countHorizontal() {
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
                    if(this.markedSpots[horCount] == this.theirShape){
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
                    if(this.markedSpots[horCount] == this.theirShape){
                        this.rowCount++;
                    }
                    horCount++;
                }
        }  
    }

    private void countBackDiagonal() {
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
                if(this.markedSpots[diagCount] == this.myShape){
                    this.backDiagCount = 0;
                    return;
                }
                else{
                    if(this.markedSpots[diagCount] == this.theirShape)
                        this.backDiagCount++;
                    diagCount += 6;
                }                
            }            
        }else{
            return;
        }
    }

    private void countForwardDiagonal() {
        int diagCount = this.theirSpot;
        
        if(diagCount == 20 || diagCount == 16 || diagCount == 12 || diagCount == 8 || diagCount == 4) {//if it's not on main diagonal skip it
            while(diagCount >= 0){
                if(this.markedSpots[diagCount] == this.myShape){
                    this.forwardDiagCount = 0;
                    return;
                }
                else{
                    if(this.markedSpots[diagCount] == this.theirShape)
                        this.forwardDiagCount++;
                    diagCount -= 4;
                }                
            }
            diagCount = this.theirSpot + 4;
            while(diagCount <= 24){
                if(this.markedSpots[diagCount] == this.myShape){
                    this.forwardDiagCount = 0;
                    return;
                }
                else{
                    if(this.markedSpots[diagCount] == this.theirShape)
                        this.forwardDiagCount++;
                    diagCount += 4;
                }                
            }
        }
        else{
            return;
        }
    }

    private void markSpot() {
        int largestCount = 0;
        if(this.columnCount > this.rowCount)
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

    private void markColumnSpot() {
        int colCount = 0;
        int colSpot = this.theirSpot;
        
        while(colSpot >= 0){
            if(this.markedSpots[colSpot] == this.myShape || this.markedSpots[colSpot] == this.theirShape)
                colSpot -= 5;
            else{
                this.markedSpots[colSpot] = this.myShape;
                this.mySpot = Integer.toString(colSpot);
                return;
            }
        }
        colSpot = this.theirSpot + 5;
        while(colSpot <= 24){
            if(this.markedSpots[colSpot] == this.myShape || this.markedSpots[colSpot] == this.theirShape)
                colSpot += 5;
            else{
                this.markedSpots[colSpot] = this.myShape;
                this.mySpot = Integer.toString(colSpot);
                return;
            }
        }
    }

    private void markRowSpot() {
        int rowCount = 0;
        int rowSpot = this.theirSpot - 1;
        
        while(rowSpot >= 0){ //check the  if statement
            if(rowSpot == 4 || rowSpot == 9 || rowSpot == 14 || rowSpot == 19 || rowSpot == 24)
                break;
            else{
                if(this.markedSpots[rowSpot] == this.myShape || this.markedSpots[rowSpot] == this.theirShape)
                    rowSpot --;
                else{
                    this.markedSpots[rowSpot] = this.myShape;
                    this.mySpot = Integer.toString(rowSpot);
                    return;
                }
            }
        }
        rowSpot = this.theirSpot + 1;
        while(rowSpot <= 24){
            if(rowSpot == 5 || rowSpot == 10 || rowSpot == 15 || rowSpot == 20)
                break;
            else{
                if(this.markedSpots[rowSpot] == this.myShape || this.markedSpots[rowSpot] == this.theirShape)
                    rowSpot ++;
                else{
                    this.markedSpots[rowSpot] = this.myShape;
                    this.mySpot = Integer.toString(rowSpot);
                    return;
                }
            }
        }
    }

    private void markBackDiagSpot() {
        int diagSpot = 0;
        
        while(diagSpot <= 24){
            if(this.markedSpots[diagSpot] == this.myShape || this.markedSpots[diagSpot] == this.theirShape)
                diagSpot += 6;
            else{
                this.markedSpots[diagSpot] = this.myShape;
                this.mySpot = Integer.toString(diagSpot);
            }
        }
    }

    private void markForwardDiagSpot() {
        int diagSpot = 4;
        
        while(diagSpot <= 20){
            if(this.markedSpots[diagSpot] == this.myShape || this.markedSpots[diagSpot] == this.theirShape)
                diagSpot += 4;
            else{
                this.markedSpots[diagSpot] = this.myShape;
                this.mySpot = Integer.toString(diagSpot);
            }
        }
    }

    private void drawGame() {
        for(int i = 0; i < 25; i++){
            if(this.markedSpots[i] == this.theirShape || this.markedSpots[i] == this.myShape)//if there is a shape here skip it
                this.rowCount++;
            else{ //mark o and break
                this.markedSpots[i] = this.myShape;
                this.mySpot = Integer.toString(i);
                return;
            }            
        }
    }
}
