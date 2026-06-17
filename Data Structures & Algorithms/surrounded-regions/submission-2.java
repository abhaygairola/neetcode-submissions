class Solution {
    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i =0; i<m;i++){
            if(board[i][0]=='O'){board[i][0] = 'T'; q.add(new int[]{i,0});}
            if(board[i][n-1]=='O'){board[i][n-1] = 'T'; q.add(new int[]{i,n-1});}
        } 

        for(int i =0; i<n;i++){
            if(board[0][i]=='O'){board[0][i] = 'T'; q.add(new int[]{0,i});}
            if(board[m-1][i]=='O'){board[m-1][i] = 'T'; q.add(new int[]{m-1,i});}
        } 

        bfs(board,q);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='T') board[i][j]='O';
            }
        }
    }

    private void bfs(char[][] board,Queue<int[]> q ){
        while(!q.isEmpty()){
            int cur[]=q.poll();
            int r = cur[0];
            int c = cur[1];
            for(int d[]:directions){
                int ar = r+d[0];
                int ac = c+d[1];

                if(ar>=0 && ar<board.length && ac>=0 && ac<board[0].length && board[ar][ac]=='O'){
                    q.add(new int[]{ar,ac});
                    board[ar][ac]='T';
                }
            }
        }
    }
}
