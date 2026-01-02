class Solution {
  int min;
    public int intersectionSizeTwo(int[][] intervals) {
      Arrays.sort(intervals, (a,b)-> {
        if( a[1]==b[1])
        return a[0]-b[0];
        return a[1]-b[1];
      });
      Set<Integer> set= new HashSet<>();
     
      int n=intervals.length;
      int arr[]=new int[n];
      int cnt=0;          

      for( int i=0;i<n;i++)
      {
        while( arr[i]<2)
        {
          int f=intervals[i][1];
          while( set.contains(f))
          {
            f--;
          }
          set.add(f);
          arr[i]++;
          if( arr[i]>=2) cnt++;
          if(cnt==n) return set.size();
          for( int j=i+1;j<n;j++)
          {
            if( intervals[j][0]<= f && intervals[j][1]>=f)
            {
              arr[j]++;
              if( arr[j]==2)
              cnt++;
              
          if(cnt==n) return set.size();
            }
            if(intervals[j][0]>f)
            break;
          }
        }       
      }
       return set.size();
      
    }
}