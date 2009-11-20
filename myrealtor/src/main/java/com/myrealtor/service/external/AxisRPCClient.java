/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.myrealtor.service.external;

import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.domain.beans.Provider;

public class AxisRPCClient {

	protected final Log log = LogFactory.getLog(getClass());

	protected RPCServiceClient serviceClient;

	public AxisRPCClient(String url) throws Exception {
		setup(url);
	}

	protected void setup(String url) throws AxisFault {
		log.debug("setup url: " + url);
		serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		EndpointReference targetEPR = new EndpointReference(url);
		options.setTo(targetEPR);
	}

	public void registerProvider(Provider provider) throws AxisFault {
		log.debug("registerProvider: " + provider);

		// QName of the target method
		QName qName = new QName("http://service.apartment.com", "registerProvider");

		// Constructing the arguments array for the method invocation
		Object[] opAddEntryArgs = new Object[] { provider };

		// Invoking the method
		serviceClient.invokeRobust(qName, opAddEntryArgs);
		
		serviceClient.cleanup();
		serviceClient.cleanupTransport();
	}

	@SuppressWarnings("unchecked")
	public List<Apartment> findApartmentList(String username, String zip) throws AxisFault {
		log.debug("findApartmentList providerId: " + username + " - zip: " + zip);

		// QName of the target method
		QName qName = new QName("http://service.apartment.com", "findApartment");

		Object[] opFindEntryArgs = new Object[] { username, zip };
		Class[] returnTypes = new Class[] { Apartment[].class };
		//Class[] returnTypes = new Class[] { List.class };

		Object[] response = serviceClient.invokeBlocking(qName, opFindEntryArgs, returnTypes);

		Apartment[] resultArray = (Apartment[]) response[0];
		//log.debug("response: " + response + "  response.length: " + response.length);		
		
		List result =  Arrays.asList( resultArray );
		
		serviceClient.cleanup();
		serviceClient.cleanupTransport();
		return result;

	}

}
