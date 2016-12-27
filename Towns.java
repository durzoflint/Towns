import java.util.*;
class Towns
{
	static int ls=0;
	static char a1[]={'A','A','E','B','C','E','C','D','E'};
	static char a2[]={'B','D','A','C','D','C','F','F','F'};
	static int d[]={5,5,6,4,2,2,4,6,1};
	static void generate(char ch,int sum, char a1[],char a2[],int d[])
	{
		if(ch=='F'&&sum<ls)
		{
			ls=sum;
			return;
		}
		for(int i=0;i<a1.length;i++)
		{
			if(a1[i]==ch)
			{
				char ax[]=remove(a1,i);
				char ay[]=remove(a2,i);
				int dx[]=removeValue(d,i);
				sum=sum+d[i];
				generate(a2[i],sum,ax,ay,dx);
				sum=sum-d[i];
			}
			else if(a2[i]==ch)
			{
				char ax[]=remove(a1,i);
				char ay[]=remove(a2,i);
				int dx[]=removeValue(d,i);
				sum=sum+d[i];
				generate(a1[i],sum,ax,ay,dx);
				sum=sum-d[i];
			}
		}
	}
	public static void main(String arghh[])
	{
		for(int i=0;i<d.length;i++)
		ls=ls+d[i];
		generate('A',0,a1,a2,d);
		System.out.println(ls);
	}
	static char[] remove(char a[],int x)
	{
		char b[]=new char[a.length-1];
		int c=0;
		for(int i=0;i<a.length;i++)
		{
			if(i==x)
			continue;
			b[c++]=a[i];
		}
		return b;
	}
	static int[] removeValue(int d[],int x)
	{
		int b[]=new int[d.length-1];
		int c=0;
		for(int i=0;i<d.length;i++)
		{
			if(i==x)
			continue;
			b[c++]=d[i];
		}
		return b;
	}
}