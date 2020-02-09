import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Classname KnightTourTest
 * @Description Knight Tour Test
 * @Date 2020/2/9 上午9:39
 * @Created by mlee1018 (https://blog.csdn.net/recall_tomorrow/article/details/70970293)
 */
public class KnightTour {

    private int X; // 棋盘的列数
    private int Y; // 棋盘的行数
    private int row;
    private int column;
    private boolean[] visited; // 用来标记棋盘上各个位置是否被访问过
    private boolean finished; // 用来标记是否期盼所有位置均被访问(意味着已成功)
    private int count = 1;

    public KnightTour(int y, int x) {
        row = y;
        column = x;
    }

    public void Process() {
        Y = 8;
        X = 8;

        int[][] chessBoard = new int[Y][X];
        visited = new boolean[X * Y];
        traversalChessBoard(chessBoard, row - 1, column - 1, 1);

        for(int[] rows : chessBoard){
            for(int columns : rows){
                System.out.print(columns + "\t");
            }
            System.out.println();
        }
    }

    public void traversalChessBoard(int[][] chessBoard, int row, int column, int step) {
        chessBoard[row][column] = step;
        visited[row * X + column] = true; // 此位置已访问
        ArrayList<Point> ps = next(new Point(column, row)); // 由当前位置得到下一次所有位置的集合
        sort(ps); // 按照当前(new Point(column, row))这步的下一步的下一步选择数目进行非递减排序

        while (!ps.isEmpty()) {
            Point p = ps.remove(0); // 每次选择仍然未选中的下一步的下一步选择数目最少的下一步作为当前这步的下一步
            if (!visited[p.y * X + p.x]) { // 这个位置没有访问，那么就从这个位置开始进行下一次访问
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }
        }
        if(step < X * Y && !finished){ // (step < X * Y)这个条件成立，有两种情况：第一种，棋盘到目前为止仍没有走完;第二种，棋盘已经走完过，此时在回溯的过程中
            chessBoard[row][column] = 0; // 如果整个棋盘最终全部为零，则表示无解
            visited[row * X + column] = false;
        }else{ // 此处代表已成功走出覆盖棋盘的完整路径，如果此时将结果输出(去掉finished变量)，以便回溯可以得到所有的结果
            finished = true;
        }
    }



    // 在当前位置p处，下一次的位置(最多有8个位置)
    public ArrayList<Point> next(Point p) {
        ArrayList<Point> ps = new ArrayList<Point>();
        Point p1 = new Point(p);
        if ((p1.x = p.x - 2) >= 0 && (p1.y = p.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x - 1) >= 0 && (p1.y = p.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x + 1) < X && (p1.y = p.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x + 2) < X && (p1.y = p.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x + 2) < X && (p1.y = p.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x + 1) < X && (p1.y = p.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x - 1) >= 0 && (p1.y = p.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = p.x - 2) >= 0 && (p1.y = p.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    // 根据当前的这一步的所有下一步的选择数目进行非递减排序
    public void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size(); // 当前这一步o1的下一步的选择数目
                int count2 = next(o2).size();
                if (count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getCount() {
        return count;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setCount(int count) {
        this.count = count;
    }
}