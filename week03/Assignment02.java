package week03;

public class Assignment02 {
	private static final int[][] maze = {
			{0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
			{0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
			{0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 0, 1, 1, 1, 0},
			{0, 1, 0, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 1, 1, 1, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 1, 1, 1, 1, 1, 0},
			{1, 1, 0, 0, 0, 0, 0, 0, 1, 0},
			{1, 1, 1, 1, 0, 1, 0, 1, 1, 0},
			{1, 1, 1, 1, 0, 1, 0, 0, 0, 0}
	};
	
	//현재위치 {row, col},
	//Start = {0, 0}
	//앞으로 가거나, 아래로 가거나.
	//base case? 끝지점.
	//row == 9, col == 9
	
	private static void escapeMaze(int[][] root, int crow, int ccol) {
		if(crow == 9 && ccol == 9)
		{
			root[crow][ccol] = 3;
		}
		else
		{
			if(crow+1 < 10)
			{
				if(root[crow+1][ccol] == 0 || root[crow+1][ccol] == 3)
				{
					root[crow][ccol] = 3;
					escapeMaze(root, crow+1, ccol);
				}
				else
				{
					//더 이상 하강이 안되면, 좌우로 이동
					if(ccol+1 < 10)
					{
						//우로 이동
						if(root[crow][ccol+1] == 0 || root[crow][ccol+1] == 3)
						{
							root[crow][ccol] = 3;
							escapeMaze(root, crow, ccol+1);
						}
						else {
							if(ccol-1 >= 0)
							{
								if(root[crow][ccol-1] == 0 || root[crow][ccol-1] == 3)
								{
									root[crow][ccol] = 2;
									escapeMaze(root,crow, ccol-1);
								}
								else
								{
									if(crow-1 >= 0)
									{
										if(root[crow-1][ccol] == 0 || root[crow-1][ccol] == 3)
										{
											root[crow][ccol] = 2;
											escapeMaze(root, crow-1, ccol);
										}
									}
								}
							}
						}
					}
				}
			}
			else if(crow+1 == 10)		//제일 아래
			{
				if(ccol+1 < 10 && (root[crow][ccol+1] == 0 || root[crow][ccol+1] == 3))
				{
					root[crow][ccol] = 3;
					escapeMaze(root, crow, ccol+1);
				}
				else
				{
					if(ccol-1 >= 0 && (root[crow][ccol-1] == 0 || root[crow][ccol-1] == 3))
					{
						root[crow][ccol] = 3;
						
						if(root[crow][ccol-1] == 3)
							root[crow][ccol] = 2;
						
						escapeMaze(root,crow, ccol-1);
					}
					else
					{
						if(crow-1 >= 0 && (root[crow-1][ccol] == 0 || root[crow-1][ccol] == 3))
						{
							root[crow][ccol] = 2;
							escapeMaze(root, crow-1, ccol);
						}
					}
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		int[][] root1 = new int[10][10];
		int[][] root2 = new int[10][10];
		System.arraycopy(maze, 0, root1, 0, maze.length);
		escapeMaze(root1, 0, 0);
		
		System.out.println("Solution 1");
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(root1[i][j] == 3)
				{
					System.out.print("*");
				}else
				{
					System.out.print(root1[i][j]);
				}
			}
			System.out.println();
		}
		
		
		System.arraycopy(root1, 0, root2, 0, maze.length);
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(root2[i][j] == 3)
					root2[i][j] = 4;
			}
		}
		
		root2[0][0] = 0;
		root2[9][9] = 0;
		escapeMaze(root2, 0, 0);
		
		System.out.println("\nSolution 2");
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(root2[i][j] == 3)
				{
					System.out.print("*");
				}else
				{
					if(root2[i][j] == 4)
						root2[i][j] = 0;
					System.out.print(root2[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	
}
