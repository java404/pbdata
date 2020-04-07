%define __jar_repack 0
%define debug_package %{nil}
%define _binaries_in_noarch_packages_terminate_build   0

Name:             smartmon-vhe
Version:          1.0.0
License:          SmartMon
Release:          1
Summary:          SmartMon VHE
Group:            Development/Tools
BuildArch:        noarch
Source0:          %{name}-%{version}.tar.gz
BuildRequires:    systemd
Requires(post):   systemd
Requires(preun):  systemd
Requires(postun): systemd

%description
SmartMon VHE Server

%prep
%setup -q

%build

%install
mkdir -p $RPM_BUILD_ROOT/opt/smartmon/vhe/
cp -v $RPM_BUILD_DIR/%{name}-%{version}/* $RPM_BUILD_ROOT/opt/smartmon/vhe/

%clean
rm -rf $RPM_BUILD_ROOT

%files
%defattr(-,root,root,-)
%doc
/opt/smartmon/vhe/smartmon-core-1.0.jar
/opt/smartmon/vhe/smartmon-gateway-1.0.jar
/opt/smartmon/vhe/smartmon-smartstor-1.0.jar
/opt/smartmon/vhe/smartmon-vhe-1.0.jar

%changelog
