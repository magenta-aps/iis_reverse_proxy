/**
 * This is the main service of CPR Broker. It allows access to CPR data through a standard PART interface.  Methods of this service are executed via local data provider whenever possible (except RefreshRead). Otherwise, an external data provider is used to implement the request.
 * 
 */
@javax.xml.bind.annotation.XmlSchema(namespace = "http://dk.itst", elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)
package itst.dk;
