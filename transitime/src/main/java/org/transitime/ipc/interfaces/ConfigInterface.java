/*
 * This file is part of Transitime.org
 * 
 * Transitime.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPL) as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * Transitime.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Transitime.org .  If not, see <http://www.gnu.org/licenses/>.
 */

package org.transitime.ipc.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

import org.transitime.db.structs.Agency;
import org.transitime.ipc.data.IpcBlock;
import org.transitime.ipc.data.IpcCalendar;
import org.transitime.ipc.data.IpcRoute;
import org.transitime.ipc.data.IpcRouteSummary;
import org.transitime.ipc.data.IpcDirectionsForRoute;
import org.transitime.ipc.data.IpcSchedule;
import org.transitime.ipc.data.IpcTrip;
import org.transitime.ipc.data.IpcTripPattern;

/**
 * Defines the RMI interface for getting configuration data.
 *
 * @author SkiBu Smith
 *
 */
public interface ConfigInterface extends Remote {

	/**
	 * Obtains list of routes configured.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public Collection<IpcRouteSummary> getRoutes() throws RemoteException;

	/**
	 * Obtains data for single route.
	 * 
	 * @param routeIdOrShortName
	 *            Specifies which route to provide data for. routeShortName is
	 *            often used instead of routeId since routeIds unfortunately
	 *            often change when there is a schedule change.
	 * @param stopId
	 *            If want UI to highlight the remaining stops and paths left in
	 *            trip then stopId is used to return which stops remain in trip.
	 *            If this additional info not needed for UI then null can be
	 *            specified.
	 * @param tripPatternId
	 *            If want UI to highlight the remaining stops and paths left in
	 *            trip then stopId is used to determine which trip pattern to
	 *            highlight. If this additional info not needed for UI then null
	 *            can be specified.
	 * @return
	 * @throws RemoteException
	 */
	public IpcRoute getRoute(String routeIdOrShortName, String stopId,
			String tripPatternId) throws RemoteException;
	
	/**
	 * Returns stops for each direction for a route.
	 * 
	 * @param routeIdOrShortName
	 *            Specifies which route to provide data for. routeShortName is
	 *            often used instead of routeId since routeIds unfortunately
	 *            often change when there is a schedule change.
	 * @return
	 * @throws RemoteException
	 */
	public IpcDirectionsForRoute getStops(String routeIdOrShortName)  
			throws RemoteException;
	
	/**
	 * Returns block info for specified blockId and serviceId. Includes all trip
	 * and trip pattern info associated with the block.
	 * 
	 * @param blockId
	 * @param serviceId
	 * @return
	 * @throws RemoteException
	 */
	public IpcBlock getBlock(String blockId, String serviceId) 
			throws RemoteException;
	
	/**
	 * Returns blocks for each service class for the blockId specified.
	 * 
	 * @param blockId
	 * @return
	 * @throws RemoteException
	 */
	public Collection<IpcBlock> getBlocks(String blockId)
			throws RemoteException;
	
	/**
	 * Returns trip info for specified tripId. Includes all trip pattern info
	 * associated with the trip.
	 * 
	 * @param tripId
	 * @return
	 * @throws RemoteException
	 */
	public IpcTrip getTrip(String tripId) 
			throws RemoteException;
	
	/**
	 * Returns trip patterns for specified routeIdOrShortName.
	 * 
	 * @param routeIdOrShortName
	 * @return
	 * @throws RemoteException
	 */
	public List<IpcTripPattern> getTripPatterns(String routeIdOrShortName) 
			throws RemoteException;

	/**
	 * Returns list of IpcSchedule objects for the specified routeIdOrShortName
	 * @param routeIdOrShortName
	 * @return
	 * @throws RemoteException
	 */
	public List<IpcSchedule> getSchedules(String routeIdOrShortName)
			throws RemoteException;
	
	/**
	 * Returns list of Agency objects containing data from GTFS agency.txt file
	 * @return
	 * @throws RemoteException
	 */
	public List<Agency> getAgencies() throws RemoteException;
	
	/**
	 * Returns list of Calendar objects that are currently active.
	 * @return
	 * @throws RemoteException
	 */
	public List<IpcCalendar> getCurrentCalendars() throws RemoteException;
	
	/**
	 * Returns list of all Calendar objects.
	 * @return
	 * @throws RemoteException
	 */
	public List<IpcCalendar> getAllCalendars() throws RemoteException;

	/**
	 * Returns list of vehicle IDs, unsorted
	 * 
	 * @return vehicle IDs
	 * @throws RemoteException
	 */
	public List<String> getVehicleIds() throws RemoteException;
	
	/**
	 * Returns list of service IDs, unsorted
	 * 
	 * @return vehicle IDs
	 * @throws RemoteException
	 */
	public List<String> getServiceIds() throws RemoteException;
	
	/**
	 * Returns list of service IDs, unsorted
	 * 
	 * @return vehicle IDs
	 * @throws RemoteException
	 */
	public List<String> getCurrentServiceIds() throws RemoteException;
	
	/**
	 * Returns list of trip IDs, unsorted
	 * 
	 * @return vehicle IDs
	 * @throws RemoteException
	 */
	public List<String> getTripIds() throws RemoteException;
	
	/**
	 * Returns list of block IDs, unsorted, duplicates removed
	 * 
	 * @return vehicle IDs
	 * @throws RemoteException
	 */
	public List<String> getBlockIds() throws RemoteException;
	
	/**
	 * Returns list of block IDs for specified serviceId, unsorted
	 * 
	 * @param serviceId If null then all block IDs are returned
	 * @return vehicle IDs
	 * @throws RemoteException
	 */
	public List<String> getBlockIds(String serviceId)
			throws RemoteException;	

}
