package com.catp.cgc.bo;

import com.catp.cgc.dao.*;
import com.catp.cgc.vo.*;

public class FeedBackBO {
	public boolean feedBack(FeedBackBean fb)
	{
		boolean b=false;
		FeedBackDAO fbdao=new FeedBackDAO();
		if((fb.getFeedback()!="")&&(fb.getFeedback().length()>10))
		{
			if((fb.getGame_title()!="")&&(fb.getVendor()!="")&&(fb.getDesc()!=""))
			{
				System.out.println("bo");
				b=fbdao.feedBack(fb);
			}
		}
		else
			b=false;
		return b;
	}
	public boolean generalFeedback(FeedBackBean fb)
	{
		boolean b=false;
		FeedBackDAO fbdao=new FeedBackDAO();
		if((fb.getFeedback()!="")&&(fb.getFeedback().length()>10))
			b=fbdao.feedBack(fb);
		return b;
	}

}
