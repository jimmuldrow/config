package com.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import javax.servlet.http.HttpServletRequest;
import org.springframework.cache.annotation.Cacheable;

@RestController
public class ApiController {	
	@Autowired
	TaxUtil taxUtil;
	
	@RequestMapping(value="/individualRate", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String individualRate(@RequestParam(required = true) String taxableIncome) {
		return taxUtil.calcTaxIndividualTaxpayer(taxableIncome);
	}
	
	@RequestMapping(value="/marriedJointReturnRate", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String marriedJointReturnRate(@RequestParam(required = true) String taxableIncome) {
		return taxUtil.calcTaxJointReturn(taxableIncome);
	}	
	
	@RequestMapping(value="/marriedFilingSeparatelyRate", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String marriedFilingSeparatelyRate(@RequestParam(required = true) String taxableIncome) {
		return taxUtil.calcTaxMarriedFilingSeparately(taxableIncome);
	}	
	
	@RequestMapping(value="/headOfHousehold", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String headOfHousehold(@RequestParam(required = true) String taxableIncome) {
		return taxUtil.calcTaxHeadOfHH(taxableIncome);
	}	
	
	@RequestMapping(value="/trustsAndEstates", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String trustsAndEstates(@RequestParam(required = true) String taxableIncome) {
		return taxUtil.calcTaxTrustsEstates(taxableIncome);
	}	
	
	/*
	 * Filing status
	 * 1 - Single
	 * 2 - Married filing jointly or surviving spouse
	 * 3 - Married filing separately
	 * 4 - Head of household
	 */
	@RequestMapping(value="/standardDeduction", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String standardDeduction(@RequestParam(required = true) String filingStatus) {
		return taxUtil.standardDeduction(calcFilingStatus(filingStatus));
	}
	
	private FilingStatus calcFilingStatus(String fs) {
		if(fs.contentEquals("1")) {
			return FilingStatus.SINGLE;
		}
		else if(fs.contentEquals("2")) {
			return FilingStatus.MARRIED_FILING_JOINTLY_OR_SURVIVING_SPOUSE;
		}
		else if(fs.contentEquals("3")) {
			return FilingStatus.MARRIED_FILING_SEPARATELY;
		}
		else if(fs.contentEquals("4")) {
			return FilingStatus.HEAD_OF_HOUSEHOLD;
		}
		
		return null;
	}
	
	/*
	 * Filing status
	 * 1 - Single
	 * 2 - Married filing jointly or surviving spouse
	 * 3 - Married filing separately
	 * 4 - Trusts and estates
	 */
	@RequestMapping(value="/alternativeMin", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String alternativeMin(@RequestParam(required = true) String filingStatusAM) {
		return taxUtil.alternativeMinimumDeduction(calcAlternativeMin(filingStatusAM));
	}
	
	private FilingStatus calcAlternativeMin(String fs) {
		if(fs.contentEquals("1")) {
			return FilingStatus.SINGLE;
		}
		else if(fs.contentEquals("2")) {
			return FilingStatus.MARRIED_FILING_JOINTLY_OR_SURVIVING_SPOUSE;
		}
		else if(fs.contentEquals("3")) {
			return FilingStatus.MARRIED_FILING_SEPARATELY;
		}
		else if(fs.contentEquals("4")) {
			return FilingStatus.TRUSTS_AND_ESTATES;
		}
		
		return null;
	}
}
