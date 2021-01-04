class Solution {
        public int kConcatenationMaxSum(int[] arr, int k) {
	 //case 1 when k==1
		if(k==1)
			return kadanes(arr);
			
		long sum=0;
		for(int ele:arr)
			sum+=ele;
			
		int[] kd=new int[2*arr.length];
		
		for(int i=0;i<kd.length;i++)
			kd[i]=arr[i%arr.length];
			
		long ans=0;
		
		if(sum<=0){            //case 2
			 ans= kadanes(kd);
		}else{                      //case 3
			ans= kadanes(kd)+(k-2)*sum;
		}
		if(ans<0)
			return 0;
		return (int)(ans%(1000000007));
	}
	
	// basic kadane code
	
	public int kadanes(int[] arr){
		int sum=0,ans=Integer.MIN_VALUE;
		for(int ele:arr){
			sum+=ele;
			if(ans<sum)
				ans=sum;
			if(sum<0)
				sum=0;
		}
		return ans;
	}
}
