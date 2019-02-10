package com.synechron.assignment.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.synechron.assignment.domain.Instrument;
import com.synechron.assignment.domain.Trade;
import com.synechron.assignment.service.impl.FileReadServiceImpl;

public class TradeInstrumentApp {
	private static final String DATE_PATTERN = "dd/MM/yyyy";
	public static void main(String[] args) throws ParseException {
		
		
		FileReadServiceImpl fileRead=new FileReadServiceImpl();
		List<Trade>trades=fileRead.getTradeDataFromFile();
		
		List<Instrument>instruments=fileRead.getInstrumentDataFromFile();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter FromDate-->");
		String formDate=sc.nextLine();
		
		System.out.println("Enter ToDate-->");
		String toDate=sc.nextLine();
		
		SimpleDateFormat format1=new SimpleDateFormat(DATE_PATTERN);
		Date fromDate=format1.parse(formDate);
		Date toDate1=format1.parse(toDate);
		
		List<Trade>filterTrades=trades.stream().filter(p->p.getDateTime().after(fromDate)&&p.getDateTime().before(toDate1)).collect(Collectors.toList());
		
		List<Object>matchingData=new ArrayList<Object>();
		List<Object>nonMatchingData=new ArrayList<Object>();
		for(Trade trade:filterTrades) {
			for(Instrument instrument:instruments) {
				if(trade.getInstrumentId().equals(instrument.getInstrumentId())) {
					matchingData.add(trade);
					matchingData.add(instrument);
				}else {
					nonMatchingData.add(instrument);
				}
			}
			
		}
		if(Objects.nonNull(filterTrades)&&filterTrades.isEmpty()) {
			for(Instrument instrument:instruments) {
		         // for(Trade trade: trades) {
		        	 // if(!trade.getInstrumentId().equals(instrument.getInstrumentId())) {
		        		  nonMatchingData.add(instrument);
		        	  //}
		         // }
				}
		}
		
		System.out.println("Instrument wise traded volume between the date range==>\n"+matchingData);
		System.out.println("List of instrument not traded between the dates==>\n"+nonMatchingData);
	}
}
