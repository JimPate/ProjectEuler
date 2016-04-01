
public class No166 {

	public static int[][] grid = new int[4][4];
	public static int x,y;
	
	public static int count=0;
	
	public static void main(String [] args) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				grid[i][j]=0;
			}
		}
		x=3;
		y=3;
		fill();
		System.out.println(count);
	}
	
	public static void fill() {
		
	}
	
	public void check() {
		int z1,z2,z3,z4,s1,s2,s3,s4,d1,d2;
		z1=grid[0][0]+grid[0][1]+grid[0][2]+grid[0][3];
		z2=grid[1][0]+grid[1][1]+grid[1][2]+grid[1][3];
		z3=grid[2][0]+grid[2][1]+grid[2][2]+grid[2][3];
		z4=grid[3][0]+grid[3][1]+grid[3][2]+grid[3][3];
		s1=grid[0][0]+grid[1][0]+grid[2][0]+grid[3][0];
		s2=grid[0][1]+grid[1][1]+grid[2][1]+grid[3][1];
		s3=grid[0][2]+grid[1][2]+grid[2][2]+grid[3][2];
		s4=grid[0][3]+grid[1][3]+grid[2][3]+grid[3][3];
		d1=grid[0][0]+grid[1][1]+grid[2][2]+grid[3][3];
		d2=grid[0][3]+grid[1][2]+grid[2][1]+grid[3][0];
		
		if(z1==z2) {
			if(z2==z3) {
				if(z3==z4) {
					if(z4==s1) {
						if(s1==s2) {
							if(s2==s3) {
								if(s3==s4) {
									if(s4==d1) {
										if(d1==d2) {
											count++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
