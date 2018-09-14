package de.springboot.rest.services.restfulwebservices;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean bean = new SomeBean("1", "2", "3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue value = new MappingJacksonValue(bean);
        value.setFilters(provider);
        return value;
    }

    @GetMapping("/filteringList")
    public MappingJacksonValue retrieveSomeBeanList() {
        SomeBean bean1 = new SomeBean("1", "2", "3");
        SomeBean bean2 = new SomeBean("1", "2", "3");
        List<SomeBean> list = Arrays.asList(bean2, bean1);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider provider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue value = new MappingJacksonValue(list);
        value.setFilters(provider);
        return value;
    }
}
