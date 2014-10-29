package oj.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/*
 * Determine if a Sudoku is valid
 * The Sudoku board could be partially filled, where empty cells are
 *  filled with the character '.'.
 *  A partially filled sudoku which is valid.
 *  Note:
 *  A valid Sudoku board (partially filled) is not necessarily solvable.
 *   Only the filled cells need to be validated.
 *   
 * 1.����Ȼ���뷨�����μ��������������У��У�9������Ԫ���Ƿ��ظ�Ҳ�Ƕ�hash��Ŀ���,O(n^2)
 * 2.����1�кܶ��ظ����߼����������õ� HashSet ��û��̫���Ҫ
 *   ����������Ҫ���ɣ�ͬʱ����������־������������������flags[0-9]�ֱ����ڱ����Ӧ�����Ƿ���ֹ���
 * 3. ��ȫ�ÿռ任ʱ�䣬����������ֱ����ڱ���j�Ƿ�����ڵ�i��(��/��/����)
 */
public class ValidSudoku {
	// 1.
	public boolean isValidSudoku1(char[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0)
			return false;
		int m = board.length, n = board[0].length;
		if(!(m == n && m % 3 == 0))
			return false;
		//
		Set<Character> set = new HashSet<Character>();
		// row case
		for(int i = 0; i < m ; i++){
			set.clear();
			// ������һ��
			for(char c : board[i]){
				boolean isValid = checkValid(set,c);
				if(!isValid) return false;
			}
		}
		
		// column case
		for(int j = 0; j < n; j++){
			set.clear();
			//������һ��
			for(int i = 0; i < m; i++){
				boolean isValid = checkValid(set, board[i][j]);
				if(!isValid) return false;
			}
		}
		
		// 9 grids
		for(int i = 0; i < m; i += 3)
			for(int j = 0; j < n; j += 3){
				// test this grid
				boolean isValid = checkGridValid(board,i,j,set);
				if(!isValid) return false;
			}
		
	 return true;       
	}

	// ���ÿ��3X3�����Ƿ���Ϲ���
	private boolean checkGridValid(char board[][], int m, int n, Set<Character> set) {
		set.clear();
		for(int i = m; i < m + 3; i++)
			for(int j = n; j < n + 3; j++){
				boolean isValid = checkValid(set,board[i][j]);
				if(!isValid) return false;
			}
		return true;
	}

	// �ڼ����в鿴�Ƿ��ظ�
	private boolean checkValid(Set<Character> set, char c) {
		if(c == '.') return true;
		if(set.contains(c)) return false;
		else set.add(c);
		return true;
	}
	
	//����߽��鲻���ص�
	public boolean isValidSudoku2(char[][] board) {
		boolean rows[] = new boolean[9]; //���ڱ�ʶ  ÿһ��1-9�Ƿ��ѳ���
		boolean cols[] = new boolean[9];
		boolean grid[] = new boolean[9];
		
		for(int i = 0; i < 9; i++){
			// �ڴ�����һ (��/��/����)֮ǰ�ȳ�ʼ��Ϊ������
			Arrays.fill(rows, false);
			Arrays.fill(cols, false);
			Arrays.fill(grid, false);
			for(int j = 0; j < 9; j++){
				boolean rowValid = checkValid2(rows, board[i][j]);
				if(!rowValid) return false;
				// ������Ч�ʺܲ�
				boolean colValid = checkValid2(cols, board[j][i]);
				if(!colValid) return false;
				
				//��һ�������Ӧ�ķֱ���0-0,0-1..0-9����������
				boolean gridValid = checkValid2(grid, board[3*(i/3) + j/3][3*(i%3) + j%3]);
				if(!gridValid) return false;
				
			}
		}
		return true;
	}

	private boolean checkValid2(boolean[] set, char c) {
		if(c == '.') return true;
		int index = c - '0' - 1;
		if(index < 0 || index > 9)
			return false;
		if(set[index] == true) return false;
		else set[index] = true;
		return true;
	}
	
	//3.
	public boolean isValidSudoku(char[][] board) {
		//���������Щ���ֵ��ص�
		// xxx[i][j] ��ʾ j�Ƿ�����ڵ�i����/��/�ӹ��� ��
		boolean rowContainer[][] = new boolean[9][9];
		boolean colContainer[][] = new boolean[9][9];
		boolean gridContainer[][] = new boolean[9][9];
		
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++){
				if(board[i][j] == '.') continue;
				int cur = board[i][j] - '1';  // index from 0
				if(rowContainer[i][cur] || colContainer[j][cur]
						|| gridContainer[3*(i/3)+j/3][cur])
					return false;
				//update
				rowContainer[i][cur] = true;
				colContainer[j][cur] = true;
				gridContainer[3*(i/3)+j/3][cur] = true;
			}
		
 		return true;
	}
	
	
}










