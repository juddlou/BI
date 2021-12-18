import java.util.Scanner;
public class Game {
    char[][] grid;
    public Game(){
        grid=new char[3][3];
    }
    public void gameStart(){
        int count=0;
        char cur='#';
        while(count<9){
            System.out.println("current player is "+cur);
            System.out.println("please input row");
            Scanner scanner=new Scanner(System.in);
            int row=scanner.nextInt();
            System.out.println("please input col");
            int col=scanner.nextInt();
            if(row>=0&&row<3&&col>=0&&col<3&&grid[row][col]!='#'&&grid[row][col]!='O'){
                grid[row][col]=cur;
                System.out.println("cur grid is ");
                printGrid();
                if(judge(grid,cur)){
                    System.out.println(cur+" win");
                    return;
                }
                cur=(cur=='#'?'O':'#');
                count++;
            }else{
                System.out.println("input invalid");
            }
        }
        System.out.println("draw");
    }

    private boolean judge(char[][] arr,char c){
        if(arr[0][0]==arr[1][1]&&arr[1][1]==arr[2][2]&&arr[1][1]==c){
            return true;
        }
        if(arr[2][0]==arr[1][1]&&arr[1][1]==arr[0][2]&&arr[1][1]==c){
            return true;
        }
        for(int i=0;i<3;i++){
            int count=0;
            for(int j=0;j<3;j++){
                if(arr[i][j]==c){
                    count++;
                }
            }
            if(count==3){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            int count=0;
            for(int j=0;j<3;j++){
                if(arr[j][i]==c){
                    count++;
                }
            }
            if(count==3){
                return true;
            }
        }
        return false;
    }

    private void printGrid(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
