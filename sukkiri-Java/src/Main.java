import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();//ピースの個数4
        int N = sc.nextInt();//パズルの大きさ4
        int M = sc.nextInt();//ピースの大きさ2
        char[][] C1 = new char[M][M];//完成系のピース形1
        char[][] C2 = new char[M][M];//完成系のピース形2
        char[][] C3 = new char[M][M];//完成系のピース形3
        char[][] C4 = new char[M][M];//完成系のピース形4
        
        
        //それぞれの完成系ピースに完成の模様を格納
        for(int i = 0; i < N; i++){
            String c = sc.next();
            char[] sp = c.toCharArray();
            if(i < M){
                for(int j = 0; j < M; j++){
                    C1[i][j] = sp[j];
                }
                for(int n  = M; n < N; n++){
                    C2[i][n-M] = sp[n];
                }
            }else{
                for(int j = 0; j < M; j++){
                    C3[i-M][j] = sp[j];
                }
                for(int n  = M; n < N; n++){
                    C4[i-M][n-M] = sp[n];
                }
            }
        }
        
        
        //メイン処理↓
        //ピースの数だけ繰り返し
        for(int i = 0; i < X; i++){
            
            //使用するピースを格納
            char[][] P = new char[M][M];
            for(int j = 0; j < M; j++){
                String p = sc.next();
                char[] sp = p.toCharArray();
                for(int n = 0; n < M; n++){
                    P[j][n] = sp[n];
                }
            }
            
            boolean flag = true;//ピースが合致するかの判定
            
            //ピースの回転数だけ繰り返し（４で固定）
            for(int k = 0; k < 4; k++){
                
                
                //正解となるピースと同じになるかを判定
                //左上のピースの判定
                flag = true;//判定をリセット
                for(int g = 0; g < M; g++){
                    for(int v = 0; v < M; v++){
                        if( C1[g][v]!=(P[g][v]) ){
                            flag =false;
                            break;
                        }
                    }
                    if(flag == false){
                        break;
                    }
                }
                //完成系のピースと合致していたら位置と回転数を出力
                if(flag == true){
                        System.out.println("1 1 " + k);
                        break;
                }
                
                
                //右上のピースの判定
                flag = true;//判定をリセット
                for(int g = 0; g < M; g++){
                    for(int v = 0; v < M; v++){
                        if( C2[g][v] != P[g][v] ){
                            flag =false;
                            break;
                        }
                    }
                    if(flag == false){
                        break;
                    }
                }
                //完成系のピースと合致していたら位置と回転数を出力
                if(flag == true){
                        System.out.println("1 "+ (M+1) +" "+ k);
                        break;
                }
                
                
                //左下の判定
                flag = true;//判定をリセット
                for(int g = 0; g < M; g++){
                    for(int v = 0; v < M; v++){
                        if( C3[g][v] != P[g][v] ){
                            flag =false;
                            break;
                        }
                    }
                    if(flag == false){
                        break;
                    }
                }
                //完成系のピースと合致していたら位置と回転数を出力
                if(flag == true){
                        System.out.println((M+1) +" 1 "+ k);
                        break;
                }
                
                
                //右下の判定
                flag = true;//判定をリセット
                for(int g = 0; g < M; g++){
                    for(int v = 0; v < M; v++){
                        if( C4[g][v] != P[g][v] ){
                            flag =false;
                            break;
                        }
                    }
                    if(flag == false){
                        break;
                    }
                }
                //完成系のピースと合致していたら位置と回転数を出力
                if(flag == true){
                    System.out.println((M+1) +" "+(M+1)+" "+ k);
                    break;
                }
                
                
                //ピースの回転処理↓
                //ピース配列のコピー
                char[][] copy = new char [M][];
                for(int g = 0; g < P.length; g++) {
                    copy[g] = new char[P[g].length];
                    System.arraycopy(P[g], 0,
                    copy[g], 0, P[g].length);
                }

                //コピーをもとに配列の行と列を入れ替える
                for(int g = 0; g < M; g++){
                    for(int v = 0; v < M; v++){
                        P[g][v] = copy[(M-1)-v][g];
                    }
                }

            }
            
            //どれにも当てはまらなかった場合
            if(flag == false){
                System.out.println(-1);
            }
            
        }
        
    }
}