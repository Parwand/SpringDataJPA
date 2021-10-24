package net.parwand.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.OverridesAttribute;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "GuardianName")),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "GuardianEmail")),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "GuardianMobile"))
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
