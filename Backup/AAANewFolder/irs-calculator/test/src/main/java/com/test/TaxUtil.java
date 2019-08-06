package com.test;

import org.springframework.stereotype.Component;

//  https://www.forbes.com/sites/kellyphillipserb/2018/11/15/irs-announces-2019-tax-rates-standard-deduction-amounts-and-more/#52045df92081

@Component
public class TaxUtil {
	BigDecimalUtil bdu = new BigDecimalUtil();
	
	public String standardDeduction(FilingStatus fs) {
		if(fs == FilingStatus.SINGLE) {
			return bdu.formatUSCurrency("12200");
		}
		else if(fs == FilingStatus.MARRIED_FILING_JOINTLY_OR_SURVIVING_SPOUSE) {
			return bdu.formatUSCurrency("24400");
		}
		else if(fs == FilingStatus.MARRIED_FILING_SEPARATELY) {
			return bdu.formatUSCurrency("12200");
		}
		else if(fs == FilingStatus.HEAD_OF_HOUSEHOLD) {
			return bdu.formatUSCurrency("18350");
		}
		
		return null;
	}
	
	public String alternativeMinimumDeduction(FilingStatus fs) {		
		if(fs == FilingStatus.SINGLE) {
			return bdu.formatUSCurrency("71700");
		}
		else if(fs == FilingStatus.MARRIED_FILING_JOINTLY_OR_SURVIVING_SPOUSE) {
			return bdu.formatUSCurrency("111700");
		}
		else if(fs == FilingStatus.MARRIED_FILING_SEPARATELY) {
			return bdu.formatUSCurrency("55850");
		}
		else if(fs == FilingStatus.TRUSTS_AND_ESTATES) {
			return bdu.formatUSCurrency("25000");
		}
		
		return null;
	}
	
	static final String[] maximumIncomeIndividual = {
			"9700", "39475", "84200", "160725", "204100", "510300", "TOP LIMIT"
	};
	
	public String calcTaxIndividualTaxpayer(String taxableIncome) {
		for(String s: maximumIncomeIndividual) {
			if(s.equals("TOP LIMIT")) {
				return finalCalc(taxableIncome, "153798.50", "0.37");
			}
			else if(s.equals("9700")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "0.0", "0.10");
				}
			}
			else if(s.equals("39475")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "970", "0.12");
				}
			}
			else if(s.equals("84200")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "4543", "0.22");
				}
			}
			else if(s.equals("160725")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "14382.50", "0.24");
				}
			}
			else if(s.equals("204100")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "32748.50", "0.32");
				}
			}
			else if(s.equals("510300")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "46628.50", "0.35");
				}
			}
		}
		
		return null;
	}
	
	/*
	 * For two tax years after the year your spouse died, you can file 
	 * as a qualifying widow or widower. This filing status gives you a 
	 * higher standard deduction and lower tax rate than filing as a single person. 
	 * You must meet these requirements: You haven't remarried, and you have a
	 * dependent child or step child (but not adopted child).
	 */
	
	static final String[] maximumIncomeJointReturn = {
			"19400", "78950", "168400", "321450", "408200", "612350", "TOP LIMIT"
	};
	
	public String calcTaxJointReturn(String taxableIncome) {
		for(String s: maximumIncomeJointReturn) {
			if(s.equals("TOP LIMIT")) {
				return finalCalc(taxableIncome, "164709.50", "0.37");
			}
			else if(s.equals("19400")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "0.0", "0.10");
				}
			}
			else if(s.equals("78950")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "1940", "0.12");
				}
			}
			else if(s.equals("168400")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "9086", "0.22");
				}
			}
			else if(s.equals("321450")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "28765", "0.24");
				}
			}
			else if(s.equals("408200")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "65497", "0.32");
				}
			}
			else if(s.equals("612350")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "93257", "0.35");
				}
			}
		}
		
		return null;
	}
	
	static final String[] maximumIncomeHeadOfHH = {
			"13850", "52850", "84200", "160700", "204100", "510300", "TOP LIMIT"
	};
	
	public String calcTaxHeadOfHH(String taxableIncome) {
		for(String s: maximumIncomeHeadOfHH) {
			if(s.equals("TOP LIMIT")) {
				return finalCalc(taxableIncome, "152380", "0.37");
			}
			else if(s.equals("13850")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "0.0", "0.10");
				}
			}
			else if(s.equals("52850")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "1385", "0.12");
				}
			}
			else if(s.equals("84200")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "6065", "0.22");
				}
			}
			else if(s.equals("160700")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "12962", "0.24");
				}
			}
			else if(s.equals("204100")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "31322", "0.32");
				}
			}
			else if(s.equals("510300")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "45210", "0.35");
				}
			}
		}
		
		return null;
	}	
	
	static final String[] maximumIncomeMarriedFilingSeparately = {
			"9700", "39475", "84200", "160725", "204100", "306175", "TOP LIMIT"
	};	
	
	public String calcTaxMarriedFilingSeparately(String taxableIncome) {
		for(String s: maximumIncomeMarriedFilingSeparately) {
			if(s.equals("TOP LIMIT")) {
				return finalCalc(taxableIncome, "82354.75", "0.37");
			}
			else if(s.equals("9700")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "0.0", "0.10");
				}
			}
			else if(s.equals("39475")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "970", "0.12");
				}
			}
			else if(s.equals("84200")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "4543", "0.22");
				}
			}
			else if(s.equals("160725")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "14382.50", "0.24");
				}
			}
			else if(s.equals("204100")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "32748.50", "0.32");
				}
			}
			else if(s.equals("306175")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "46628.50", "0.35");
				}
			}
		}
		
		return null;
	}	
	
	static final String[] maximumIncomeTrustsEstates = {
			"2600", "9300", "12750", "TOP LIMIT"
	};	
	
	public String calcTaxTrustsEstates(String taxableIncome) {
		for(String s: maximumIncomeTrustsEstates) {
			if(s.equals("TOP LIMIT")) {
				return finalCalc(taxableIncome, "3075.50", "0.37");
			}
			else if(s.equals("2600")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "0.0", "0.10");
				}
			}
			else if(s.equals("9300")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "260", "0.24");
				}
			}
			else if(s.equals("12750")) {
				double d1 = bdu.compareBd(taxableIncome, s);
				
				if(d1 <= 0) {
					return finalCalc(taxableIncome, "1868", "0.35");
				}
			}
		}
		
		return null;
	}	
	
	private String finalCalc(String taxableIncome, String taxOnLowerAmount, String percent) {
		String s1 = bdu.subtractBd(taxableIncome,  taxOnLowerAmount);
		String s2 = bdu.multiplyBd(s1,  percent);
		String s3 = bdu.addBd(s2, taxOnLowerAmount);
		return bdu.formatUSCurrency(s3);		
	}		
}
