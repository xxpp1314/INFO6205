class Solution {
    public String removeKdigits(String num, int k) {
        char[] str = num.toCharArray();
    	int length = num.length();
    	if(k == 0)
    	{
    		return num;
    	}
    	if(k == num.length())
    	{
    		return "0";
    	}
    	while(k != 0)
    	{
    		int i;
    		int flag = 1;
    		for(i = 0; i < str.length - 1; i++)
    		{
    			if((int)str[i] > (int)str[i+1])
    			{
    				for(int t = i; t < str.length - 1; t++)
    				{
    					str[t] = str[t+1];
    				}
    				flag = 0;
    				length--;
    				k--;
    				break;
    			}
    		}
			if(flag == 1 && k!=0)
			{			
				length--;		
				k--;	
			}
    	}
    	boolean cut = true;
    	while(cut)
    	{
    		cut = false;
    		if(str[0] == '0'&&length!=1)
    		{
    			cut = true;
    			for(int t = 0; t < str.length - 1 ; t++)
    			{
    				str[t] = str[t+1];
    			}
    			length--;
    		}
    	}	
    	char[] pre = new char[length];
    	for(int i = 0; i < length; i++)
    	{	
    		pre[i] = str[i];
    	}
	return String.valueOf(pre);
    }
}
