package com.synechron.assignment.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.synechron.assignment.domain.Instrument;
import com.synechron.assignment.domain.Trade;

public class FileReadServiceImpl {

	private static final String TRADE_FILE_PATH = "resource/trades.txt";
	private static final String INST_FILE_PATH = "resource/inst.txt";
	private static final String REGEX_SEPARATOR = ",";
	private static final String PATTERN = "dd/MM/yyyy";

	public List<Trade> getTradeDataFromFile() {

		List<Trade> trades = new ArrayList<Trade>();
		try {
			File file = new File(TRADE_FILE_PATH);
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			// skip first Line
			br.readLine();

			String line;
			SimpleDateFormat format = new SimpleDateFormat(PATTERN);

			while ((line = br.readLine()) != null) {
				String[] tradData = line.split(REGEX_SEPARATOR);
				Trade trade2 = new Trade();
				for (int trade = 0; trade < tradData.length; trade++) {
					trade2.setTradeId(tradData[0]);
					trade2.setDateTime(format.parse(tradData[1]));
					trade2.setInstrumentId(tradData[2]);
					trade2.setPrice(Float.parseFloat(tradData[3]));
					trade2.setQuantity(Integer.parseInt(tradData[4]));
					trade2.setAmount(Float.parseFloat(tradData[5]));
					trade2.setTrader(tradData[6]);
				}
				trades.add(trade2);

			}
		} catch (Exception e) {
		}
		return trades;

	}

	public List<Instrument> getInstrumentDataFromFile() {
		List<Instrument> instruments = new ArrayList<Instrument>();
		try {
			File file = new File(INST_FILE_PATH);
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			// skip first Line
			br.readLine();
			String line;

			while ((line = br.readLine()) != null) {
				String[] instData = line.split(REGEX_SEPARATOR);
				Instrument instrument = new Instrument();
				for (int inst = 0; inst < instData.length; inst++) {

					instrument.setInstrumentId(instData[0]);
					instrument.setInstrumentName(instData[1]);
				}
				instruments.add(instrument);
			}
		} catch (Exception e) {
		}
		return instruments;

	}

}
