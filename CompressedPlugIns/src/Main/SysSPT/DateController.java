package Main.SysSPT;

import java.text.*;
import java.util.*;

public class DateController {
	Date date_dat;
	SimpleDateFormat SimDatFmt;
	
	public void Test() {
		SimDatFmt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		
		date_dat = new Date();
		
		SimDatFmt.format(date_dat);
	}
}
