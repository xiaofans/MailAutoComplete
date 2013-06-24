package com.example.mailautocomplete;

import java.util.ArrayList;
import java.util.List;


import android.widget.Filter;

public class CustomFilter extends Filter{
	private AutoCompleteAdapter adapter;
	String emails[] = new String[]{"@163.com","@126.com","@qq.com","@sina.com","@soho.com","@yeah.net","@188.com","@yahoo.com","@live.com","@gmail.com"};
	public CustomFilter(AutoCompleteAdapter adapter){
		this.adapter = adapter;
	}
	
	@Override
	protected FilterResults performFiltering(CharSequence constraint) {
		FilterResults fr = null;
        if (constraint != null)
        {
            List<MailBean> result = getFilterdValues(constraint.toString());

            if (result != null)
            {
                fr = new FilterResults();
                fr.values = result;
                fr.count = result.size();
            }
        }
        return fr;
	}

	private List<MailBean> getFilterdValues(String string) {
		List<MailBean> list = new ArrayList<MailBean>();
		if(string.indexOf("@") == -1){
			for(int i = 0; i < emails.length;i++){
				MailBean mailBean = new MailBean();
				mailBean.setName(string+emails[i]);
				list.add(mailBean);
			}
		}
		if(string.indexOf("@") != -1){
			for(int i = 0; i < emails.length;i++){
				String last = string.substring(string.indexOf("@"));
				if(emails[i].contains(last)){
					MailBean mailBean = new MailBean();
					mailBean.setName(string.substring(0,string.indexOf("@")-1)+emails[i]);
					list.add(mailBean);
				}
				
			}
		}
		return list;
	}
	
	@Override
    protected void publishResults(CharSequence constraint,
            FilterResults results) {
		adapter.clear();
        if (results != null)
        {
            if (results.values != null)
            {
                List<MailBean> items = (List<MailBean>) results.values;
                    for (MailBean listItem : items) {
                    	adapter.add(listItem);
                    }

                if (items.size() > 0)
                {
                	adapter.notifyDataSetChanged();
                    return;
                }
            }
        }
        adapter.notifyDataSetInvalidated();
    }
	
	
	
	




	
}
