
public class map {
	private box[][] b = new box[50][50];
	private TYPE type;
	
	public map(){
		
		for(int i=0;i<50;i++){
			for(int j=0;j<50;j++){
				if(i==0 || i==49 || j==0 || j==49){
					type = TYPE.wall;
				}
				else{
					type = TYPE.path;
				}
				b[i][j] = new box(j*50,i*50,type);
			}
		}
	}
}
