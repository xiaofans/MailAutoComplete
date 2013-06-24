package com.example.mailautocomplete;


import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

public class AutoCompleteAdapter extends ArrayAdapter<MailBean>{
	
	private CustomFilter filter;

	public AutoCompleteAdapter(Context context, 
			int textViewResourceId) {
		super(context, textViewResourceId);
	
	}

	@Override
	public Filter getFilter() {
		if(filter == null) filter = new CustomFilter(this);
		return filter;
	}

}
