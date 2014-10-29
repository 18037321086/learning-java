package oj.leetcode;


/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
����Union find�㷨������Ϊ��ͬ����ͨ�����Ȼ����ͨ�����O���Ҳ�������Ե��O����ô��˵������Χ
������UF�㷨�����ϣ���Ҫ���Ӷ���ļ�¼

��ʱ �� 2h
 */
public class SurroundedRegions {
	int unionSet[];
	boolean hasEdgeO[];  //���������Ƿ��б߽��ϵ�O
	
	public void solve(char[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0)
			return;
		
		int row = board.length, col = board[0].length;
		int unionSize = row * col;
		unionSet = new int[unionSize];
		hasEdgeO = new boolean[unionSize];
		// ��ʼ�����鼯�ϱ�ʶ����
		for(int i = 0; i < unionSize; i ++){
			unionSet[i] = i;
			int x = i / col, y = i % col; // locate
			hasEdgeO[i] = (board[x][y]=='O') && 
					(x == 0 || x == row - 1 || y == 0 || y == col - 1);
		}
		
		//����������󣬱ȶԵ�ǰԪ�غ������Ϸ����ҷ������ܷ�ϲ�
		for(int i = 0; i < unionSize ; i++){
			int x = i / col, y = i % col;
			int up = x - 1, right = y + 1;
			if(up >= 0 && board[x][y] == board[up][y])
				union(i, i - col);
			if(right < col && board[x][y] == board[x][right])
				union(i, i + 1);
		}
		
		//Ȼ�� flipping
		for(int i = 0; i < unionSize ; i++){
			int x = i / col, y = i % col;
			// �ر�Ҫע������ Ҫ�����ڵ�����
			if(board[x][y] == 'O' && !hasEdgeO[find(i)])
				board[x][y] = 'X';
		}
	}

	// ������� quick-union ����
	private void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		//Լ���ϲ�����һ����ͨ����
		unionSet[rootX] = rootY;
		boolean b = hasEdgeO[rootX] || hasEdgeO[rootY];
		hasEdgeO[rootX] = b;
		hasEdgeO[rootY] = b;
	}
	
	private int find(int x){
		if(x == unionSet[x])
			return x;
		unionSet[x] = find(unionSet[x]);
		return unionSet[x];
	}
	
	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
		char board[][] = {
				{'O','X','X','O','X'},
				{'X','O','O','X','O'},
				{'X','O','X','O','X'},
				{'O','X','O','O','O'},
				{'X','X','O','X','O'}
				};
		
		sr.solve(board);
		//System.out.println();
		}
}



