/*
 * This file is part of Transitime.org
 * 
 * Transitime.org is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License (GPL) as published by the
 * Free Software Foundation, either version 3 of the License, or any later
 * version.
 * 
 * Transitime.org is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * Transitime.org . If not, see <http://www.gnu.org/licenses/>.
 */

package org.transitime.api.data;

import javax.xml.bind.annotation.XmlAttribute;

import org.transitime.db.structs.Extent;
import org.transitime.utils.Geo;

/**
 * Describes the extent of a route or agency via a min & max lat & lon.
 *
 * @author SkiBu Smith
 *
 */
public class ApiExtent {

	@XmlAttribute
	private String minLat;

	@XmlAttribute
	private String minLon;

	@XmlAttribute
	private String maxLat;

	@XmlAttribute
	private String maxLon;

	/********************** Member Functions **************************/

	/**
	 * Need a no-arg constructor for Jersey. Otherwise get really obtuse
	 * "MessageBodyWriter not found for media type=application/json" exception.
	 */
	protected ApiExtent() {
	}

	public ApiExtent(Extent extent) {
		this.minLat = Geo.format(extent.getMinLat());
		this.minLon = Geo.format(extent.getMinLon());
		this.maxLat = Geo.format(extent.getMaxLat());
		this.maxLon = Geo.format(extent.getMaxLon());
	}

}
